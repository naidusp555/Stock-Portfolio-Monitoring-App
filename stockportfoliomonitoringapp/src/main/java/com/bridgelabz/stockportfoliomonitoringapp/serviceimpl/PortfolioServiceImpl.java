
package com.bridgelabz.stockportfoliomonitoringapp.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;
import com.bridgelabz.stockportfoliomonitoringapp.repository.HoldingRepository;
import com.bridgelabz.stockportfoliomonitoringapp.service.PortfolioService;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private HoldingRepository holdingRepository;

    @Override
    public List<HoldingResponseDto> getHoldingsByPortfolioId(Long portfolioId) {
        List<Holding> holdings = holdingRepository.findByPortfolioId(portfolioId);
        return holdings.stream()
                .map(h -> new HoldingResponseDto(h.getStockSymbol(), h.getQuantity(), h.getBuyPrice()))
                .collect(Collectors.toList());
    }
}
