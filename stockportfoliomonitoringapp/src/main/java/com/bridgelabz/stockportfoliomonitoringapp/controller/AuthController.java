package com.bridgelabz.stockportfoliomonitoringapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.stockportfoliomonitoringapp.dto.AuthRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.AuthResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.service.AuthService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")

public class AuthController {
	@Autowired
	private AuthService authService;
	
	@PostMapping("/auth/register")
	public ResponseEntity<AuthResponseDto> userRegisteration(@RequestBody AuthRequestDto request){
		AuthResponseDto response = authService.registerUser(request);
        return ResponseEntity.ok(response);
	}

}
