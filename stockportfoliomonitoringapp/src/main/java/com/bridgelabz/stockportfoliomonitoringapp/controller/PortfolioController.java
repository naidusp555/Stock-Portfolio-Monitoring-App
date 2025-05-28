package com.bridgelabz.stockportfoliomonitoringapp.controller;

import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/portfolios")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;


    @PostMapping("/create")
    public ResponseEntity<PortfolioResponseDto> createPortfolio(@RequestBody PortfolioRequestDto request, @RequestParam long id) {

        PortfolioResponseDto response = portfolioService.createPortfolio(request, id);
        return ResponseEntity.ok(response);
    }

}
