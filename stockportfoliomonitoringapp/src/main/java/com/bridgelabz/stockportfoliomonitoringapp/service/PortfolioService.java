

package com.bridgelabz.stockportfoliomonitoringapp.service;

import java.util.List;

import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioResponseDto;

public interface PortfolioService {
    List<HoldingResponseDto> getHoldingsByPortfolioId(Long portfolioId);
    public PortfolioResponseDto createPortfolio(PortfolioRequestDto request, long userId);
	public PortfolioResponseDto getAllPortfolios(long userId);
}
