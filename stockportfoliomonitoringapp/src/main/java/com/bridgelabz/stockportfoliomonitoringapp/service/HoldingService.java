package com.bridgelabz.stockportfoliomonitoringapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;
import com.bridgelabz.stockportfoliomonitoringapp.repository.HoldingRepository;

@Service
public class HoldingService {

    @Autowired
    private HoldingRepository holdingRepository;

    public List<HoldingDto> getHoldingsByPortfolioId(Long portfolioId) {
        List<Holding> holdings = holdingRepository.findByPortfolioId(portfolioId);
        return holdings.stream()
                .map(h -> new HoldingDto(
                        h.getStockSymbol(),
                        h.getQuantity(),
                        h.getBuyPrice()
                ))
                .collect(Collectors.toList());
    }
}
