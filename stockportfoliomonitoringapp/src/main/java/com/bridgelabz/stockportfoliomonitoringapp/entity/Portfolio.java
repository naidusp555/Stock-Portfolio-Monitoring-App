package com.bridgelabz.stockportfoliomonitoringapp.entity;

import java.util.List;
import jakarta.persistence.Entity;

@Entity
public class Portfolio {
	
	private long id;
	private String name;
	private User user;
	private List<Holding> holdings;
	
	
	public Portfolio() {
		super();
	}
	
	public Portfolio(long id, String name, User user, List<Holding> holdings) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
		this.holdings = holdings;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
		return "Portfolio [id=" + id + ", name=" + name + ", user=" + user + ", holdings=" + holdings + "]";
	}
}
