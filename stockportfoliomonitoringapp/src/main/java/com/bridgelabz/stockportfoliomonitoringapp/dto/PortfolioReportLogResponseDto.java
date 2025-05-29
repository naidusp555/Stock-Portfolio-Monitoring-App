package com.bridgelabz.stockportfoliomonitoringapp.dto;

public class PortfolioReportLogResponseDto {
	private double totalValue;
	private double totalGainLoss;
	private double percentReturn;
	
	public double getPercentReturn() {
		return percentReturn;
	}
	public void setPercentReturn(double percentReturn) {
		this.percentReturn = percentReturn;
	}
	public PortfolioReportLogResponseDto() {
		super();
	}
	public PortfolioReportLogResponseDto(double totalValue, double totalGainLoss, double percentReturn) {
		super();
		this.totalValue = totalValue;
		this.totalGainLoss = totalGainLoss;
		this.percentReturn = percentReturn;
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
	
}
