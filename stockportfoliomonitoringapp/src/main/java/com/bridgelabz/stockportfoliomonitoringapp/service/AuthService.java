package com.bridgelabz.stockportfoliomonitoringapp.service;



import com.bridgelabz.stockportfoliomonitoringapp.dto.LoginRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.LoginResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.RegisterRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.RegisterResponseDto;


public interface AuthService{
	public RegisterResponseDto registerUser(RegisterRequestDto request);
	public LoginResponseDto loginUser(LoginRequestDto request);
	
}
