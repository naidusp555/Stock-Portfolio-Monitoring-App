package com.bridgelabz.stockportfoliomonitoringapp.service;

import com.bridgelabz.stockportfoliomonitoringapp.dto.AuthRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.AuthResponseDto;

public interface AuthService {

	AuthResponseDto registerUser(AuthRequestDto request);

}
