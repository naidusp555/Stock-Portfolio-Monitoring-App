package com.bridgelabz.stockportfoliomonitoringapp.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "user")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String username;
	private String email;
	private String password;
	private String role;
	
	@OneToOne
	@JoinColumn(name = "portfolio_id")
	private Portfolio portfolios;
	
	
	public User() {
		super();
	}

	public User(long userId, String username, String email, String password, String role, Portfolio portfolios) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.portfolios = portfolios;
	}

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Portfolio getPortfolios() {
		return portfolios;
	}
	public void setPortfolios(Portfolio portfolios) {
		this.portfolios = portfolios;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password + ", role="
				+ role + ", portfolios=" + portfolios + "]";
	}

}
