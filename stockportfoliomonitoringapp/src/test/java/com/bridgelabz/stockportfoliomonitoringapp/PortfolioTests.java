package com.bridgelabz.stockportfoliomonitoringapp;

import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Portfolio;
import com.bridgelabz.stockportfoliomonitoringapp.entity.User;
import com.bridgelabz.stockportfoliomonitoringapp.repository.PortfolioRepository;
import com.bridgelabz.stockportfoliomonitoringapp.repository.UserRepository;
import com.bridgelabz.stockportfoliomonitoringapp.serviceimpl.PortfolioServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PortfolioTests {

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
