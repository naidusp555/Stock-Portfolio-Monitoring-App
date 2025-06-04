package com.bridgelabz.stockportfoliomonitoringapp.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class PortfolioReportLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long portfolioReportLogId;
	private LocalDate date;
	private double totalValue;
	private double totalGainLoss;
	@ManyToOne
	@JoinColumn(name = "portfolio_id")
	private Portfolio portfolio;
	public Long getPortfolioReportLogId() {
		return portfolioReportLogId;
	}
	public void setPortfolioReportLogId(Long portfolioReportLogId) {
		this.portfolioReportLogId = portfolioReportLogId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	public double getTotalGainLoss() {
		return totalGainLoss;
	}
	public void setTotalGainLoss(double totalGainLoss) {
		this.totalGainLoss = totalGainLoss;
	}
	public Portfolio getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
	
	

}
