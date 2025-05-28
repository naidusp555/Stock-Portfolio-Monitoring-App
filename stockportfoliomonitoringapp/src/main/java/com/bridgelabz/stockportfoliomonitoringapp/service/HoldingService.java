package com.bridgelabz.stockportfoliomonitoringapp.service;


import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;

public interface HoldingService {
    HoldingResponseDto addHolding(Long portfolioId, String stockSymbol, int quantity, double buyPrice);
  Holding updateHolding(Long id, Holding updatedData);
}
