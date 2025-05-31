package com.bridgelabz.stockportfoliomonitoringapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.service.PortfolioService;


@RestController
@RequestMapping("/api/portfolios" )
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;


    //Fetch all Portfolios
    @GetMapping("/{userId}")
    public ResponseEntity<PortfolioResponseDto> getAllPortfolios(@PathVariable long userId){

        PortfolioResponseDto portfolioResponseDto = portfolioService.getAllPortfolios(userId);
        return new ResponseEntity<>(portfolioResponseDto, HttpStatus.OK);

    }
    //Creates portfolio
    @PostMapping("/{userId}")
    public ResponseEntity<PortfolioResponseDto> createPortfolio(@RequestBody PortfolioRequestDto request, @PathVariable long userId){


        PortfolioResponseDto portfolioResponseDto = portfolioService.createPortfolio(request, userId);
        return new ResponseEntity<>(portfolioResponseDto, HttpStatus.OK);
    }
    //Getting holdings
    @GetMapping("/{id}/holdings")
    public ResponseEntity<List<HoldingResponseDto>> getHoldingsByPortfolioId(@PathVariable("id") Long portfolioId) {
        List<HoldingResponseDto> holdings = portfolioService.getHoldingsByPortfolioId(portfolioId);
        return ResponseEntity.ok(holdings);
    }


}