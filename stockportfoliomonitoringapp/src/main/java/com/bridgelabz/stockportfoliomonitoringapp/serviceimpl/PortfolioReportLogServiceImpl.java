package com.bridgelabz.stockportfoliomonitoringapp.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioReportLogResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;
import com.bridgelabz.stockportfoliomonitoringapp.entity.PortfolioReportLog;
import com.bridgelabz.stockportfoliomonitoringapp.repository.HoldingRepository;
import com.bridgelabz.stockportfoliomonitoringapp.repository.PortfolioReportLogRepository;
import com.bridgelabz.stockportfoliomonitoringapp.service.PortfolioReportLogService;
import com.bridgelabz.stockportfoliomonitoringapp.util.GainLossCalculator;

@Service
public class PortfolioReportLogServiceImpl implements PortfolioReportLogService {
	
	@Autowired 
	HoldingRepository holdingRepository;
	
	@Autowired
	PortfolioReportLogRepository portfolioReportLogRepository;
	
	@Override
	public PortfolioReportLogResponseDto getReport(Long portfolioId) {
		//Portfolio 
	        List<Holding> holdings = holdingRepository.findAllByPortfolioPortfolioId(portfolioId);
	        //LocalDate currentDate = LocalDate.now();
	        PortfolioReportLogResponseDto portfolioReportLogResponseDto = GainLossCalculator.calculate(holdings);
//	        PortfolioReportLog portfolioReportLog = new PortfolioReportLog();
	        //portfolioReportLog.setDate(currentDate);
	        //portfolioReportLog.setPortfolio();
	        
	        
	        return portfolioReportLogResponseDto;
	    
	}
}
