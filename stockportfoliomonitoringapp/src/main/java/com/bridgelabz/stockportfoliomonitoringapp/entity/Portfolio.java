package com.bridgelabz.stockportfoliomonitoringapp.entity;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "portfolio")
public class Portfolio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long portfolioId;

	private String name;

	@OneToOne
	@JoinColumn(name = "user_id")  // This ensures user_id is stored in the portfolio table
	private User user;

	@OneToMany(mappedBy = "portfolio")
	private List<Holding> holdings;

	@OneToMany(mappedBy = "portfolio")
	private List<PortfolioReportLog> portfolioReportLog;

	public Portfolio() {
		super();
	}

	public Portfolio(long portfolioId, String name, User user, List<Holding> holdings) {
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

	public List<PortfolioReportLog> getPortfolioReportLog() {
		return portfolioReportLog;
	}

	public void setPortfolioReportLog(List<PortfolioReportLog> portfolioReportLog) {
		this.portfolioReportLog = portfolioReportLog;
	}

	@Override
	public String toString() {
		return "Portfolio [portfolioId=" + portfolioId + ", name=" + name + ", user=" + user + ", holdings=" + holdings + "]";
	}
}
