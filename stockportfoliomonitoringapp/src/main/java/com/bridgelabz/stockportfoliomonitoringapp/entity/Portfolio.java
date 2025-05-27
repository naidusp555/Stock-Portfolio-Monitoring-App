package com.bridgelabz.stockportfoliomonitoringapp.entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "portfolio")
public class Portfolio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long portfolioId;
	private String name;
	@OneToOne
	private User user;
	@OneToMany
	private List<Holding> holdings;
	
	
	public Portfolio() {
		super();
	}
	
	public Portfolio(long portfolioId, String name, User user, List<Holding> holdings) {
		super();
		this.portfolioId = portfolioId;
		this.name = name;
		this.user = user;
		this.holdings = holdings;
	}
	public long getPortfolioId() {
		return portfolioId;
	}
	public void setPortfolioId(long portfolioId) {
		this.portfolioId = portfolioId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Holding> getHoldings() {
		return holdings;
	}
	public void setHoldings(List<Holding> holdings) {
		this.holdings = holdings;
	}
	
	@Override
	public String toString() {
		return "Portfolio [portfolioId=" + portfolioId + ", name=" + name + ", user=" + user + ", holdings=" + holdings + "]";
	}
}
