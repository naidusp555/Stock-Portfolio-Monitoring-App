package com.bridgelabz.stockportfoliomonitoringapp.dto;

public class HoldingResponseDto {
    private String stockSymbol;
	private int quantity;
    private double buyPrice;

    public HoldingResponseDto(String stockSymbol, int quantity, double buyPrice) {
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
    }
    
	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

    
}
