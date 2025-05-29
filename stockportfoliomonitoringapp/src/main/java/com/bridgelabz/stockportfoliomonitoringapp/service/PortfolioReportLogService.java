package com.bridgelabz.stockportfoliomonitoringapp.service;

import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioReportLogResponseDto;

public interface PortfolioReportLogService {
	PortfolioReportLogResponseDto getReport(Long portfolioId);
}
