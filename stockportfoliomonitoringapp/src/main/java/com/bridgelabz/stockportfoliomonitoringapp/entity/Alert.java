package com.bridgelabz.stockportfoliomonitoringapp.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Alert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long alertId;
	private String stockSymbol;
	private double priceThreshold;
	private double portfolioLossPercentage;
	private boolean triggered;
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
	public Alert() {
		super();
	}
	public Alert(long alertId, String stockSymbol, double priceThreshold, double portfolioLossPercentage,
			boolean triggered, User user) {
		super();
		this.alertId = alertId;
		this.stockSymbol = stockSymbol;
		this.priceThreshold = priceThreshold;
		this.portfolioLossPercentage = portfolioLossPercentage;
		this.triggered = triggered;
		this.user = user;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
