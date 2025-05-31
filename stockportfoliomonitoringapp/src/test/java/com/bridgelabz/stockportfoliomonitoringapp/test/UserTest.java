package com.bridgelabz.stockportfoliomonitoringapp.test;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.bridgelabz.stockportfoliomonitoringapp.dto.LoginRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.LoginResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.RegisterRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.RegisterResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.User;
import com.bridgelabz.stockportfoliomonitoringapp.repository.UserRepository;
import com.bridgelabz.stockportfoliomonitoringapp.serviceimpl.AuthServiceImpl;

public class UserTest {
	
	 	@Mock
	    private UserRepository userRepository;

	    @InjectMocks
	    private AuthServiceImpl authService;

	    @Test
	    public void testRegisterUser() {
	        RegisterRequestDto requestDto = new RegisterRequestDto();
	        requestDto.setUsername("shadow");
	        requestDto.setEmail("shadow@example.com");
	        requestDto.setPassword("Strong@123");

	        when(userRepository.findByEmail("shadow@example.com")).thenReturn(Optional.empty());

	        RegisterResponseDto response = authService.registerUser(requestDto);
	        
	        assertEquals("shadow", response.getUsername());
	        assertEquals("User registered successfully", response.getMessage());

	    }
	    
	    @Test
	    public void testLoginUser() {
	        LoginRequestDto requestDto = new LoginRequestDto();
	        requestDto.setEmail("messi555@gmail.com");
	        requestDto.setPassword("goat@123");

	        User mockUser = new User();
	        mockUser.setEmail("messi555@gmail.com");
	        mockUser.setPassword("goat@123");

	        when(userRepository.findByEmail("messi555@gmail.com")).thenReturn(Optional.of(mockUser));

	        LoginResponseDto response = authService.loginUser(requestDto);

	        assertEquals("messi555@gmail.com", response.getEmail());
	        assertEquals("fhuen", response.getToken());
	        assertEquals("Logged in", response.getMessage());
	    }   

}
