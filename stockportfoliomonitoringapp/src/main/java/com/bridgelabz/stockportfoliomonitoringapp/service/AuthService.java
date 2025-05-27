package com.bridgelabz.stockportfoliomonitoringapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
	@Autowired
    private HoldingRepository holdingRepository;

    @Override
    public List<HoldingDto> getHoldingsByPortfolioId(Long portfolioId) {
        List<Holding> holdings = holdingRepository.findByPortfolioId(portfolioId);
        return holdings.stream()
                .map(h -> new HoldingDto(h.getStockSymbol(), h.getQuantity(), h.getBuyPrice()))
                .collect(Collectors.toList());
    }

}
