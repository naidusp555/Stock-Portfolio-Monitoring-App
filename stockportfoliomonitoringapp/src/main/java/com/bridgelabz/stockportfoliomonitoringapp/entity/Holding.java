package com.bridgelabz.stockportfoliomonitoringapp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "holding")
public class Holding {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long holdingId;
	private String stockSymbol;
	private int quantity;
	private double buyPrice;
	@ManyToOne
	@JoinColumn(name = "portfolioId")
	private Portfolio portfolio;
	
	
	public Holding() {
		super();
	}
	
	public Holding(long holdingId, String stockSymbol, int quantity, double buyPrice, Portfolio portfolio) {
		super();
		this.holdingId = holdingId;
		this.stockSymbol = stockSymbol;
		this.quantity = quantity;
		this.buyPrice = buyPrice;
		this.portfolio = portfolio;
	}
	public long getHoldingId() {
		return holdingId;
	}
	public void setHoldingId(long holdingId) {
		this.holdingId = holdingId;
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
	public Portfolio getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	@Override
	public String toString() {
		return "Holding [holdingId=" + holdingId + ", stockSymbol=" + stockSymbol + ", quantity=" + quantity + ", buyPrice="
				+ buyPrice + ", portfolio=" + portfolio + "]";
	}

}
