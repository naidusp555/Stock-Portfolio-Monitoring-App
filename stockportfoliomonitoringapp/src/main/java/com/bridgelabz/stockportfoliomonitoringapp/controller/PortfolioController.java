package com.bridgelabz.stockportfoliomonitoringapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingDto;
import com.bridgelabz.stockportfoliomonitoringapp.service.HoldingService;

@RestController
@RequestMapping("/api/portfolios")
public class PortfolioController {

    @Autowired
    private HoldingService holdingService;

    @GetMapping("/{id}/holdings")
    public ResponseEntity<List<HoldingDto>> getHoldingsByPortfolioId(@PathVariable("id") Long portfolioId) {
        List<HoldingDto> holdings = holdingService.getHoldingsByPortfolioId(portfolioId);
        return ResponseEntity.ok(holdings);
    }
}
