package com.bridgelabz.stockportfoliomonitoringapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.nio.channels.NonReadableChannelException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.LoginRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.LoginResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.RegisterRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.RegisterResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;
import com.bridgelabz.stockportfoliomonitoringapp.entity.User;
import com.bridgelabz.stockportfoliomonitoringapp.repository.HoldingRepository;
import com.bridgelabz.stockportfoliomonitoringapp.repository.UserRepository;
import com.bridgelabz.stockportfoliomonitoringapp.service.HoldingService;
import com.bridgelabz.stockportfoliomonitoringapp.serviceimpl.AuthServiceImpl;

@ExtendWith(MockitoExtension.class)

@SpringBootTest
class StockportfoliomonitoringappApplicationTests {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private AuthServiceImpl authService;

	
	@Test
	public void UserRegistrationtest() {
	    RegisterRequestDto requestDto = new RegisterRequestDto();
	    requestDto.setUsername("shadow");
	    requestDto.setEmail("shadow@example.com");
	    requestDto.setPassword("Strong@123");

	    when(userRepository.findByEmail("shadow@example.com")).thenReturn(Optional.empty());

	   RegisterResponseDto response = authService.registerUser(requestDto);
			   
	    assertEquals("shadow", response.getUsername());
	    assertEquals("User registered successfully", response.getMessage());
	    
	    verify(userRepository, times(1)).save(any(User.class));
	}

	
	@Test
	public void userLoginTest() {
		LoginRequestDto requestDto = new LoginRequestDto();
		requestDto.setEmail("messi555@gmail.com");
		requestDto.setPassword("goat@123");
		
		User mockuser = new User();
		mockuser.setEmail("messi555@gmail.com");
		mockuser.setPassword("goat@123");
		
		when(userRepository.findByEmail("messi555@gmail.com")).thenReturn(Optional.empty());
		
		LoginResponseDto responseDto = authService.loginUser(requestDto);
		
		assertEquals("messi555@gmail.com", responseDto.getEmail());
		assertEquals("Logged in", responseDto.getMessage());
		
	}
	
	@Mock
	private HoldingRepository holdingRepository;
	
	@InjectMocks
	private HoldingService holdingService;
	

	@Test
	public void testUpdateHolding() {
	       
		Long id = 1L;

        Holding existing = new Holding();
        existing.setStockSymbol("AAPL");
        existing.setQuantity(10);
        existing.setBuyPrice(140.00);

        HoldingRequestDto requestDto = new HoldingRequestDto();
        requestDto.setQuantity(20);
        requestDto.setBuyPrice(155.50);

        Holding updated = new Holding();
        updated.setStockSymbol("AAPL");
        updated.setQuantity(20);
        updated.setBuyPrice(155.50);
        
        when(holdingRepository.findById(id)).thenReturn(Optional.of(existing));
        when(holdingRepository.save(any(Holding.class))).thenReturn(updated);
        
        HoldingResponseDto response = holdingService.updateHolding(id, requestDto);

        assertEquals("AAPL", response.getStockSymbol());
        assertEquals(20, response.getQuantity());
        assertEquals(155.50, response.getBuyPrice());
        
        
	}
	
	
}

