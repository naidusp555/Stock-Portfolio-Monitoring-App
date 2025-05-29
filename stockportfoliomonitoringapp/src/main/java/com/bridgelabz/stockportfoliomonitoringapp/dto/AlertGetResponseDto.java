package com.bridgelabz.stockportfoliomonitoringapp.dto;



public class AlertGetResponseDto {
	
	private long alertId;
	private String stockSymbol;
	private double priceThreshold;
	private double portfolioLossPercentage;
	private boolean triggered;
	
	
	public AlertGetResponseDto() {
		super();
	}
	public AlertGetResponseDto(long alertId, String stockSymbol, double priceThreshold, double portfolioLossPercentage,
			boolean triggered) {
		super();
		this.alertId = alertId;
		this.stockSymbol = stockSymbol;
		this.priceThreshold = priceThreshold;
		this.portfolioLossPercentage = portfolioLossPercentage;
		this.triggered = triggered;
	}
	public long getAlertId() {
		return alertId;
	}
	public void setAlertId(long alertId) {
		this.alertId = alertId;
	}
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public double getPriceThreshold() {
		return priceThreshold;
	}
	public void setPriceThreshold(double priceThreshold) {
		this.priceThreshold = priceThreshold;
	}
	public double getPortfolioLossPercentage() {
		return portfolioLossPercentage;
	}
	public void setPortfolioLossPercentage(double portfolioLossPercentage) {
		this.portfolioLossPercentage = portfolioLossPercentage;
	}
	public boolean isTriggered() {
		return triggered;
	}
	public void setTriggered(boolean triggered) {
		this.triggered = triggered;
	}
	

}
