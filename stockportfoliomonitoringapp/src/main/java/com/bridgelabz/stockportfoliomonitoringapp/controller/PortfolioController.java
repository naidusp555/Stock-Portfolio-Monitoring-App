package com.bridgelabz.stockportfoliomonitoringapp.controller;

import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Portfolio;
import com.bridgelabz.stockportfoliomonitoringapp.repository.UserRepository;
import com.bridgelabz.stockportfoliomonitoringapp.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController

@RequestMapping("/api/portfolios")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Portfolio> createPortfolio(@RequestBody PortfolioDto portfolioDto, Principal principal) {
        Long userId = getUserIdFromPrincipal(principal);
        Portfolio created = portfolioService.createPortfolio(portfolioDto, userId);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }


    private Long getUserIdFromPrincipal(Principal principal) {
        String username = principal.getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"))
                .getId();
    }

}
