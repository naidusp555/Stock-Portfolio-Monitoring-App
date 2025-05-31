package com.bridgelabz.stockportfoliomonitoringapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioReportLogResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.service.PortfolioReportLogService;


@RestController
@RequestMapping("/api/reports")
public class PortfolioReportLogController {
	
	@Autowired
	PortfolioReportLogService portfolioReportLogService;
	
	
	
	@GetMapping("/portfolio-summary/{portfolioId}")
	public ResponseEntity<PortfolioReportLogResponseDto> getReport(@PathVariable Long portfolioId){
		return ResponseEntity.ok(portfolioReportLogService.getReport(portfolioId));
	}
	
	@GetMapping("/download/pdf/{portfolioId}")
	public ResponseEntity<String> downloadReport(@PathVariable Long portfolioId){
		return ResponseEntity.ok(portfolioReportLogService.generateReport(portfolioId));
	}

}
