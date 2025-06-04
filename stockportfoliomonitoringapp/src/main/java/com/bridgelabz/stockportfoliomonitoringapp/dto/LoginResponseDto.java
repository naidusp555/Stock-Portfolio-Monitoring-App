package com.bridgelabz.stockportfoliomonitoringapp.dto;

public class LoginResponseDto {
	
	private String message;
	private String token;
	private String userName;
	private String email;
	
	public LoginResponseDto() {
		super();
	}
	
	public LoginResponseDto(String token, String userName, String email, String message) {
		super();
		this.token = token;
		this.userName = userName;
		this.email = email;
		this.message = message;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
	
	
	
}
