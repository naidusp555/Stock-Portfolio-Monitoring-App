package com.bridgelabz.stockportfoliomonitoringapp.entity;

import java.util.List;
import jakarta.persistence.Entity;

@Entity
public class User {
	
	private long id;
	private String username;
	private String email;
	private String password;
	private String role;
	private List<Portfolio> portfolios;
	
	
	public User() {
		super();
	}

	public User(long id, String username, String email, String password, String role, List<Portfolio> portfolios) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.portfolios = portfolios;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public List<Portfolio> getPortfolios() {
		return portfolios;
	}
	public void setPortfolios(List<Portfolio> portfolios) {
		this.portfolios = portfolios;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", role="
				+ role + ", portfolios=" + portfolios + "]";
	}

}
