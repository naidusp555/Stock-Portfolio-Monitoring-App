package com.bridgelabz.stockportfoliomonitoringapp;


import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Portfolio;
import com.bridgelabz.stockportfoliomonitoringapp.entity.User;
import com.bridgelabz.stockportfoliomonitoringapp.repository.HoldingRepository;
import com.bridgelabz.stockportfoliomonitoringapp.repository.PortfolioRepository;
import com.bridgelabz.stockportfoliomonitoringapp.repository.UserRepository;
import com.bridgelabz.stockportfoliomonitoringapp.service.PortfolioService;
import com.bridgelabz.stockportfoliomonitoringapp.serviceimpl.PortfolioServiceImpl;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PortfolioTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PortfolioRepository portfolioRepository;

    @InjectMocks
    private PortfolioServiceImpl portfolioService;
    
    
    @Mock
    private HoldingRepository holdingRepository;

   
    
     
//    Test to get all holdings by portfolio Id
    @Test
    public void testGetHoldingsByPortfolioId_Success() {
        Long portfolioId = 1L;
        
        Portfolio portfolio = new Portfolio();
        portfolio.setPortfolioId(portfolioId);
        portfolio.setName("Test Portfolio");
        
        Holding holding1 = new Holding();
        holding1.setHoldingId(1L);
        holding1.setStockSymbol("AAPL");
        holding1.setQuantity(10);
        holding1.setBuyPrice(150.50);
        holding1.setPortfolio(portfolio);
        
        Holding holding2 = new Holding();
        holding2.setHoldingId(2L);
        holding2.setStockSymbol("GOOGL");
        holding2.setQuantity(5);
        holding2.setBuyPrice(2500.75);
        holding2.setPortfolio(portfolio);
        
        List<Holding> mockHoldings = Arrays.asList(holding1, holding2);
        
        when(holdingRepository.findAllByPortfolioPortfolioId(portfolioId)).thenReturn(mockHoldings);
        
        List<HoldingResponseDto> result = portfolioService.getHoldingsByPortfolioId(portfolioId);
        
        assertEquals(2, result.size());
        assertEquals("AAPL", result.get(0).getStockSymbol());
        assertEquals(10, result.get(0).getQuantity());
        assertEquals(150.50, result.get(0).getBuyPrice());
        assertEquals("GOOGL", result.get(1).getStockSymbol());
        assertEquals(5, result.get(1).getQuantity());
        assertEquals(2500.75, result.get(1).getBuyPrice());
    }





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
        PortfolioResponseDto response = portfolioService.createPortfolio(request, userid);

        assertEquals(10, response.getPortfolioId());
        assertEquals("My Portfolio", response.getName());


    }
    @Test
    public void getAllPortfoliosTest(){
        long userid=1;
        Portfolio portfolio = new Portfolio();
        portfolio.setPortfolioId(10);
        portfolio.setName("Mohanraj");

        when(portfolioRepository.findByUserUserId(userid)).thenReturn(Optional.of(portfolio));

        PortfolioResponseDto response = portfolioService.getAllPortfolios(userid);

        assertEquals(10,response.getPortfolioId());
        assertEquals("Mohanraj",response.getName());
    }
    
    
}
