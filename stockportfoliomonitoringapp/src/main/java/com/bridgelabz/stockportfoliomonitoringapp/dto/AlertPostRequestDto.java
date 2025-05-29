package com.bridgelabz.stockportfoliomonitoringapp.dto;

public class AlertPostRequestDto {
	private String stockSymbol;
	private double priceThreshold;
	public AlertPostRequestDto() {
		super();
	}
	public AlertPostRequestDto(String stockSymbol, double priceThreshold) {
		super();
		this.stockSymbol = stockSymbol;
		this.priceThreshold = priceThreshold;
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
}
