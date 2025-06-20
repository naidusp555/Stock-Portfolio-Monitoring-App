package com.bridgelabz.stockportfoliomonitoringapp.dto;

public class RegisterResponseDto {
	
	private String token;
    private String username;
    private String email;
    private String role;
    private String message;
    
    
	public RegisterResponseDto() {
		super();
	}
	
	
	public RegisterResponseDto(String message) {
		super();
		this.message = message;
	}


	public RegisterResponseDto(String token, String username, String email, String role) {
		super();
		this.token = token;
		this.username = username;
		this.email = email;
		this.role = role;
	}


	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
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
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
    
    

}
