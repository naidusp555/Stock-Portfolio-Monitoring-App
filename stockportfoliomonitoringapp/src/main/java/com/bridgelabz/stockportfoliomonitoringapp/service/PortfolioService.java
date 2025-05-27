package com.bridgelabz.stockportfoliomonitoringapp.service;

import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Portfolio;
import java.util.List;

public interface PortfolioService {
    Portfolio createPortfolio(PortfolioDto portfolioDto,Long userId);
    List<Portfolio> getPortfoliosByUser(Long userId);
}
