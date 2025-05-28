package com.bridgelabz.stockportfoliomonitoringapp.dto;

import jakarta.validation.constraints.Email;

public class LoginRequestDto {
	
	@Email(message = "Invalid email format")
	private String email;
	private String password;
	
	
	public LoginRequestDto() {
		super();
	}

	public LoginRequestDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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
	

}
