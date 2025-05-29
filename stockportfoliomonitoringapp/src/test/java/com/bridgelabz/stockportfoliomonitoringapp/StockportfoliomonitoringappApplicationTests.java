package com.bridgelabz.stockportfoliomonitoringapp;




import com.bridgelabz.stockportfoliomonitoringapp.controller.HoldingController;
import com.bridgelabz.stockportfoliomonitoringapp.service.HoldingService;
import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Portfolio;
import com.bridgelabz.stockportfoliomonitoringapp.entity.User;
import com.bridgelabz.stockportfoliomonitoringapp.repository.PortfolioRepository;
import com.bridgelabz.stockportfoliomonitoringapp.repository.UserRepository;
import com.bridgelabz.stockportfoliomonitoringapp.serviceimpl.PortfolioServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StockportfoliomonitoringappApplicationTests {
	@Mock
	private HoldingService holdingService;

	@InjectMocks
	private HoldingController holdingController;

	@Mock
	private UserRepository userRepository;

	@Mock
	private PortfolioRepository portfolioRepository;

	@InjectMocks
	private PortfolioServiceImpl portfolioServiceImpl;


	@Test
	public void testCreatePortfolio() {
		long userid=1;
		PortfolioRequestDto request = new PortfolioRequestDto();
		request.setName("My Portfolio");

		User user=new User();
		user.setUserId(userid);

		Portfolio savedPortfolio= new Portfolio();
		savedPortfolio.setPortfolioId(10);
		savedPortfolio.setName("My Portfolio");
		savedPortfolio.setUser(user);

		when(userRepository.findByUserId(userid)).thenReturn(user);
		when(portfolioRepository.save(any(Portfolio.class))).thenReturn(savedPortfolio);
		when(userRepository.save(any(User.class))).thenReturn(user);
		PortfolioResponseDto response = portfolioServiceImpl.createPortfolio(request, userid);

		assertEquals(10, response.getPortfolioId());
		assertEquals("My Portfolio", response.getName());


	}


	@Test
	public void testDeleteHolding_Success() {
		Long holdingId = 1L;
		String successMessage = "Holding deleted successfully.";

		when(holdingService.deleteHoldingById(holdingId)).thenReturn(successMessage);

		ResponseEntity<String> response = holdingController.deleteHolding(holdingId);

		assertEquals(200, response.getStatusCodeValue());
		assertEquals(successMessage, response.getBody());
	}

	@Test
	public void testDeleteHolding_NotFound() {
		Long holdingId = 999L;
		String errorMessage = "Holding not found.";

		when(holdingService.deleteHoldingById(holdingId)).thenReturn(errorMessage);

		ResponseEntity<String> response = holdingController.deleteHolding(holdingId);

		assertEquals(404, response.getStatusCodeValue());
		assertEquals(errorMessage, response.getBody());

	public void getAllPortfoliosTest(){
		long userid=1;
		Portfolio portfolio = new Portfolio();
		portfolio.setPortfolioId(10);
		portfolio.setName("Mohanraj");

		when(portfolioRepository.findByUserUserId(userid)).thenReturn(Optional.of(portfolio));

		PortfolioResponseDto response = portfolioServiceImpl.getAllPortfolios(userid);

		assertEquals(10,response.getPortfolioId());
		assertEquals("Mohanraj",response.getName());

	}


}