package com.bridgelabz.stockportfoliomonitoringapp.serviceimpl;

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
}
