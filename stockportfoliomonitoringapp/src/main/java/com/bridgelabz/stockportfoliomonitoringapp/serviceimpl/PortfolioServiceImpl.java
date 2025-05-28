
package com.bridgelabz.stockportfoliomonitoringapp.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Portfolio;
import com.bridgelabz.stockportfoliomonitoringapp.entity.User;
import com.bridgelabz.stockportfoliomonitoringapp.repository.HoldingRepository;
import com.bridgelabz.stockportfoliomonitoringapp.repository.PortfolioRepository;
import com.bridgelabz.stockportfoliomonitoringapp.repository.UserRepository;
import com.bridgelabz.stockportfoliomonitoringapp.service.PortfolioService;

@Service
public class PortfolioServiceImpl implements PortfolioService {
    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private HoldingRepository holdingRepository;

    @Override
    public List<HoldingResponseDto> getHoldingsByPortfolioId(Long portfolioId) {
        List<Holding> holdings = holdingRepository.findHoldingByPortfolioId(portfolioId);
        return holdings.stream()
                .map(h -> new HoldingResponseDto(h.getStockSymbol(), h.getQuantity(), h.getBuyPrice()))
                .collect(Collectors.toList());
    }
    


    // Create Portfolio
    @Override
    public PortfolioResponseDto createPortfolio(PortfolioRequestDto request, long id) {
        //fetching portfolio by id
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        Portfolio portfolio = new Portfolio();
        portfolio.setName(request.getName());
        portfolio.setUser(user);

        Portfolio savedPortfolio = portfolioRepository.save(portfolio);

        return new PortfolioResponseDto(
                savedPortfolio.getId(),
                savedPortfolio.getName(),
                user.getUsername()
        );
}
}    
