package com.bridgelabz.stockportfoliomonitoringapp.service;

import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioResponseDto;

public interface PortfolioService {
    PortfolioResponseDto createPortfolio(PortfolioRequestDto request, long id);

}
