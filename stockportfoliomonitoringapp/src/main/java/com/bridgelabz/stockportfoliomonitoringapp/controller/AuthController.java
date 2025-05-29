package com.bridgelabz.stockportfoliomonitoringapp.controller;

import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.stockportfoliomonitoringapp.dto.LoginRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.LoginResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.RegisterRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.RegisterResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.service.AuthService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/auth/register")
    public ResponseEntity<RegisterResponseDto> userRegisteration(@Valid @RequestBody RegisterRequestDto registerRequestDto) {
        System.out.println("Incoming request: " + registerRequestDto.getUsername() + ", " +
                registerRequestDto.getEmail() + ", " + registerRequestDto.getPassword());

        RegisterResponseDto response = authService.registerUser(registerRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponseDto> userLogin(@Valid @RequestBody LoginRequestDto request) {
        LoginResponseDto response = authService.loginUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
