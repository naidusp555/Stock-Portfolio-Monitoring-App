package com.bridgelabz.stockportfoliomonitoringapp.service;

import java.util.List;

import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingResponseDto;

public interface PortfolioService {
    List<HoldingResponseDto> getHoldingsByPortfolioId(Long portfolioId);
}
