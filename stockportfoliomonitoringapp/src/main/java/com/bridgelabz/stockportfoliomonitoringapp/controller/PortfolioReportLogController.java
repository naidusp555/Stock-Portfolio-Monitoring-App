package com.bridgelabz.stockportfoliomonitoringapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.stockportfoliomonitoringapp.repository.PortfolioReportLogRepository;


@RestController
@RequestMapping("/api/reports")
public class PortfolioReportLogController {
	
	@Autowired
	PortfolioReportLogRepository portfolioReportLogRepository;
	
	
	

}
