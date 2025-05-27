package com.bridgelabz.stockportfoliomonitoringapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.stockportfoliomonitoringapp.service.AuthService;

@RestController
public class AuthController {

	@Autowired
    private AuthService authService;
	
	
    @GetMapping("/api/portfolios/{id}/holdings")
    public ResponseEntity<List<HoldingDto>> getHoldingsByPortfolioId(@PathVariable("id") Long portfolioId) {
        List<HoldingDto> holdings = authService.getHoldingsByPortfolioId(portfolioId);
        return ResponseEntity.ok(holdings);
    }
}
