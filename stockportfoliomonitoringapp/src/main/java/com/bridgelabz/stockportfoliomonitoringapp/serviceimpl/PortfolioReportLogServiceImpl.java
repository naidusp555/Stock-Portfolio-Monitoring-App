package com.bridgelabz.stockportfoliomonitoringapp.serviceimpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioReportLogResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Portfolio;
import com.bridgelabz.stockportfoliomonitoringapp.entity.PortfolioReportLog;
import com.bridgelabz.stockportfoliomonitoringapp.repository.HoldingRepository;
import com.bridgelabz.stockportfoliomonitoringapp.repository.PortfolioReportLogRepository;
import com.bridgelabz.stockportfoliomonitoringapp.repository.PortfolioRepository;
import com.bridgelabz.stockportfoliomonitoringapp.service.PortfolioReportLogService;
import com.bridgelabz.stockportfoliomonitoringapp.util.GainLossCalculator;

@Service
public class PortfolioReportLogServiceImpl implements PortfolioReportLogService {

	@Autowired 
	HoldingRepository holdingRepository;

	@Autowired
	PortfolioReportLogRepository portfolioReportLogRepository;
	
	@Autowired
	PortfolioRepository portfolioRepository;

	@Override
	public PortfolioReportLogResponseDto getReport(Long portfolioId) {
		Optional<Portfolio> optionaPortfolio = portfolioRepository.findById(portfolioId);
		Portfolio portfolio = optionaPortfolio.get();
		List<Holding> holdings = holdingRepository.findAllByPortfolioPortfolioId(portfolioId);
		LocalDate currentDate = LocalDate.now();
		PortfolioReportLogResponseDto portfolioReportLogResponseDto = GainLossCalculator.calculate(holdings);
		PortfolioReportLog portfolioReportLog = new PortfolioReportLog();
		portfolioReportLog.setDate(currentDate);
		portfolioReportLog.setPortfolio(portfolio);
		portfolioReportLog.setTotalGainLoss(portfolioReportLogResponseDto.getTotalGainLoss());
		portfolioReportLog.setTotalValue(portfolioReportLogResponseDto.getTotalValue());
		
		portfolioReportLogRepository.save(portfolioReportLog);

		return portfolioReportLogResponseDto;

	}
	
	public String generateReport(Long portfolioId) {
	    List<PortfolioReportLog> logs = portfolioReportLogRepository.findAllByPortfolioPortfolioId(portfolioId);

	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Report.txt"))) {
	        writer.write(String.format("%-25s %-15s %-25s %-15s %-12s\n",
	                "PortfolioReportLogId", "Date", "TotalGainLoss", "TotalValue", "PortfolioId"));

	        for (PortfolioReportLog log : logs) {
	            writer.write(String.format("%-25d %-15s %-25.15f %-15.2f %-12d\n",
	                    log.getPortfolioReportLogId(),
	                    log.getDate().toString(),
	                    log.getTotalGainLoss(),
	                    log.getTotalValue(),
	                    log.getPortfolio().getPortfolioId()));
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        return "Failed to generate report.";
	    }

	    return "Successfully generated TXT report.";
	}

}
