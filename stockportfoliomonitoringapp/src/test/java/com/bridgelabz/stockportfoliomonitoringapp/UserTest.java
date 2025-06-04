package com.bridgelabz.stockportfoliomonitoringapp;


import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Optional;



import com.bridgelabz.stockportfoliomonitoringapp.dto.LoginRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.LoginResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.RegisterRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.RegisterResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.User;
import com.bridgelabz.stockportfoliomonitoringapp.repository.UserRepository;
import com.bridgelabz.stockportfoliomonitoringapp.service.AuthService;
import com.bridgelabz.stockportfoliomonitoringapp.serviceimpl.AuthServiceImpl;



@ExtendWith(MockitoExtension.class)
public class UserTest {
	
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	AuthServiceImpl authService;
	
	//Register Test
	
	@Test
	public void userRegistrationTest() {
	    RegisterRequestDto requestDto = new RegisterRequestDto();
	    requestDto.setUsername("shadow");
	    requestDto.setEmail("shadow@example.com");
	    requestDto.setPassword("Strong@123");

	    User savedUser = new User();
	    savedUser.setUserId(1L); // optional, just for completeness
	    savedUser.setUsername(requestDto.getUsername());
	    savedUser.setEmail(requestDto.getEmail());
	    savedUser.setPassword(requestDto.getPassword());

	    when(userRepository.findByEmail("shadow@example.com"))
	        .thenReturn(Optional.empty()); // simulate that email doesn't exist

	    when(userRepository.save(Mockito.any(User.class)))
	        .thenReturn(savedUser); // save() returns User, not DTO

	    RegisterResponseDto response = authService.registerUser(requestDto);

	    assertEquals("shadow", response.getUsername());
	    assertEquals("User registered successfully", response.getMessage());
	}

	
	//Login Test

	@Test
    public void testLoginUser_Success() {
        // Prepare request
        LoginRequestDto request = new LoginRequestDto();
        request.setEmail("shadow@example.com");
        request.setPassword("Strong@123");

        // Prepare mock user
        User user = new User();
        user.setUsername("shadow");
        user.setEmail("shadow@example.com");
        user.setPassword("Strong@123");

        // Mock repository behavior
        when(userRepository.findByEmail("shadow@example.com"))
            .thenReturn(Optional.of(user));

        // Execute method
        LoginResponseDto response = authService.loginUser(request);

        // Assertions
        assertEquals("shadow", response.getUserName());
        assertEquals("shadow@example.com", response.getEmail());
        assertEquals("You have successfully logged in.", response.getMessage());
        assertNull(response.getToken()); // if token is null in the logic
    }

    @Test
    public void testLoginUser_EmailNotRegistered() {
        LoginRequestDto request = new LoginRequestDto();
        request.setEmail("unknown@example.com");
        request.setPassword("anyPassword");

        when(userRepository.findByEmail("unknown@example.com"))
            .thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            authService.loginUser(request);
        });

        assertEquals("Email is not registered", exception.getMessage());
    }

    @Test
    public void testLoginUser_IncorrectPassword() {
        LoginRequestDto request = new LoginRequestDto();
        request.setEmail("shadow@example.com");
        request.setPassword("wrongPassword");

        User user = new User();
        user.setUsername("shadow");
        user.setEmail("shadow@example.com");
        user.setPassword("Strong@123");

        when(userRepository.findByEmail("shadow@example.com"))
            .thenReturn(Optional.of(user));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            authService.loginUser(request);
        });

        assertEquals("Incorrect password", exception.getMessage());
    }

	
}
