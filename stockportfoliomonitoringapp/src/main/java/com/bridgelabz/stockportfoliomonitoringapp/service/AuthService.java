package com.bridgelabz.stockportfoliomonitoringapp.service;

import org.springframework.stereotype.Service;

import com.bridgelabz.stockportfoliomonitoringapp.dto.LoginRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.LoginResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.RegisterRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.RegisterResponseDto;

@Service
public interface AuthService{
	public RegisterResponseDto registerUser(RegisterRequestDto request);
	public LoginResponseDto loginUser(LoginRequestDto request);
	
}

