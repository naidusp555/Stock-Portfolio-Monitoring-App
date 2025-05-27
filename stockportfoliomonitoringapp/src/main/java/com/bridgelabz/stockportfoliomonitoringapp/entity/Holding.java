package com.bridgelabz.stockportfoliomonitoringapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Holding {

	@Id
	private long id;
	private String stockSymbol;
	private int quantity;
	private double buyPrice;
	private Portfolio portfolio;
	
	
	public Holding() {
		super();
	}
	
	public Holding(long id, String stockSymbol, int quantity, double buyPrice, Portfolio portfolio) {
		super();
		this.id = id;
		this.stockSymbol = stockSymbol;
		this.quantity = quantity;
		this.buyPrice = buyPrice;
		this.portfolio = portfolio;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
		return "Holding [id=" + id + ", stockSymbol=" + stockSymbol + ", quantity=" + quantity + ", buyPrice="
				+ buyPrice + ", portfolio=" + portfolio + "]";
	}

}
