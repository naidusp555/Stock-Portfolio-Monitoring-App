package com.bridgelabz.stockportfoliomonitoringapp.dto;

public class AlertUpdateRequestDto {
	private Double priceThreshold;
    private Double portfolioLossPercentage;
	public AlertUpdateRequestDto() {
		super();
	}
	public Double getPriceThreshold() {
		return priceThreshold;
	}
	public void setPriceThreshold(Double priceThreshold) {
		this.priceThreshold = priceThreshold;
	}
	public Double getPortfolioLossPercentage() {
		return portfolioLossPercentage;
	}
	public void setPortfolioLossPercentage(Double portfolioLossPercentage) {
		this.portfolioLossPercentage = portfolioLossPercentage;
	}
    
}
