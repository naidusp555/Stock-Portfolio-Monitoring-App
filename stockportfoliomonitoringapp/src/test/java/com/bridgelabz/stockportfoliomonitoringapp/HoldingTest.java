package com.bridgelabz.stockportfoliomonitoringapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Portfolio;
import com.bridgelabz.stockportfoliomonitoringapp.entity.User;
import com.bridgelabz.stockportfoliomonitoringapp.repository.HoldingRepository;
import com.bridgelabz.stockportfoliomonitoringapp.repository.PortfolioRepository;
import com.bridgelabz.stockportfoliomonitoringapp.repository.UserRepository;
import com.bridgelabz.stockportfoliomonitoringapp.service.HoldingService;
import com.bridgelabz.stockportfoliomonitoringapp.serviceimpl.HoldingServiceImpl;
import com.bridgelabz.stockportfoliomonitoringapp.serviceimpl.PortfolioServiceImpl;



@ExtendWith(MockitoExtension.class)
public class HoldingTest {
	
	@Mock
    private HoldingService holdingService;

    @Mock
    private HoldingRepository holdingRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PortfolioRepository portfolioRepository;

    @InjectMocks
    private HoldingServiceImpl holdingServiceImpl;

    @InjectMocks
    private PortfolioServiceImpl portfolioServiceImpl;

	
	@Test
    public void testAddHolding_Success() {
        Long portfolioId = 1L;
        
        HoldingRequestDto request = new HoldingRequestDto();
        request.setPortfolioId(portfolioId);
        request.setStockSymbol("AAPL");
        request.setQuantity(10);
        request.setBuyPrice(150.50);
        
        User user = new User();
        user.setUserId(1L);
        
        
        
        Portfolio portfolio = new Portfolio();
        portfolio.setPortfolioId(portfolioId);
        portfolio.setName("Test Portfolio");
        portfolio.setUser(user);
        Optional<Portfolio> optionalPortfolio = Optional.of(portfolio);
        
        Holding savedHolding = new Holding();
        savedHolding.setHoldingId(1L);
        savedHolding.setStockSymbol("AAPL");
        savedHolding.setQuantity(10);
        savedHolding.setBuyPrice(150.50);
        savedHolding.setPortfolio(portfolio);
        
        when(portfolioRepository.findByPortfolioId(portfolioId)).thenReturn(optionalPortfolio);
        when(holdingRepository.save(savedHolding)).thenReturn(savedHolding);
        
        HoldingResponseDto response = holdingServiceImpl.addHolding(request);
        
        assertEquals("AAPL", response.getStockSymbol());
        assertEquals(10, response.getQuantity());
        assertEquals(150.50, response.getBuyPrice());
    }



}
