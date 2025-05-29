package com.bridgelabz.stockportfoliomonitoringapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.bridgelabz.stockportfoliomonitoringapp.controller.AuthController;
import com.bridgelabz.stockportfoliomonitoringapp.controller.HoldingController;
import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.LoginRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.LoginResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.RegisterRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.RegisterResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.repository.UserRepository;
import com.bridgelabz.stockportfoliomonitoringapp.service.AuthService;
import com.bridgelabz.stockportfoliomonitoringapp.service.HoldingService;



@SpringBootTest
class StockportfoliomonitoringappApplicationTests {

	@Mock
	private AuthService service;

	@InjectMocks
	private AuthController authController;

	
	@Test
	public void UserRegistrationtest() {
	    RegisterRequestDto requestDto = new RegisterRequestDto();
	    requestDto.setUsername("shadow");
	    requestDto.setEmail("shadow@example.com");
	    requestDto.setPassword("Strong@123");

	    //long userId = 101L;

	    RegisterResponseDto mockResponse = new RegisterResponseDto();
	    mockResponse.setUsername("shadow");
	    mockResponse.setMessage("User registered successfully");

	    when(service.registerUser(requestDto)).thenReturn(mockResponse);

	    ResponseEntity<RegisterResponseDto> response = authController.userRegisteration(requestDto);

	    assertEquals("shadow", response.getBody().getUsername());
	    assertEquals("User registered successfully", response.getBody().getMessage());
	}

	
	@Test
	public void userLoginTest() {
		LoginRequestDto requestDto = new LoginRequestDto();
		requestDto.setEmail("messi555@gmail.com");
		requestDto.setPassword("goat@123");
		
		LoginResponseDto responseDto = new LoginResponseDto();
		responseDto.setEmail("messi555@gmail.com");
		responseDto.setToken("fhuen");
		responseDto.setMessage("Logged in");
		
		when(service.loginUser(requestDto)).thenReturn(responseDto);
		
		ResponseEntity<LoginResponseDto> responseEntity = authController.userLogin(requestDto);
		
		assertEquals("messi555@gmail.com", responseEntity.getBody().getEmail());
		assertEquals("fhuen", responseEntity.getBody().getToken());
		
	}
	
	@Mock
	private HoldingService holdingService;
	
	@InjectMocks
	private HoldingController holdingController;
	
	 @BeforeEach
	    public void setup() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    public void testUpdateHolding() {
	        Long id = 1L;

	        HoldingRequestDto requestDto = new HoldingRequestDto();
	        requestDto.setQuantity(20);
	        requestDto.setBuyPrice(155.50);

	        HoldingResponseDto mockResponse = new HoldingResponseDto();
	        mockResponse.setStockSymbol("AAPL");
	        mockResponse.setQuantity(20);
	        mockResponse.setBuyPrice(155.50);

	        when(holdingService.updateHolding(id, requestDto)).thenReturn(mockResponse);

	        ResponseEntity<HoldingResponseDto> response = holdingController.updateHolding(id, requestDto);

	        assertEquals("AAPL", response.getBody().getStockSymbol());
	        assertEquals(20, response.getBody().getQuantity());
	        assertEquals(155.50, response.getBody().getBuyPrice());
	    }
	
	
}

