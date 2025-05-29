
package com.bridgelabz.stockportfoliomonitoringapp.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Portfolio;
import com.bridgelabz.stockportfoliomonitoringapp.entity.User;
import com.bridgelabz.stockportfoliomonitoringapp.exception.UserNotFoundException;
import com.bridgelabz.stockportfoliomonitoringapp.repository.HoldingRepository;
import com.bridgelabz.stockportfoliomonitoringapp.repository.PortfolioRepository;
import com.bridgelabz.stockportfoliomonitoringapp.repository.UserRepository;
import com.bridgelabz.stockportfoliomonitoringapp.service.PortfolioService;

@Service
public class PortfolioServiceImpl implements PortfolioService {
    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private HoldingRepository holdingRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    //Fetch all portfolios
    @Override
 	public PortfolioResponseDto getAllPortfolios(long userId) {
 		
    	 Optional<Portfolio> portfolio = portfolioRepository.findByUserUserId(userId);
    	 if(!portfolio.isPresent()) {
    		 throw new UserNotFoundException("Portfolio not found for userId: " + userId);
    	 }
    	
    	 PortfolioResponseDto portfolioResponseDto = new PortfolioResponseDto();
    	 portfolioResponseDto.setPortfolioId(portfolio.get().getPortfolioId());
    	 portfolioResponseDto.setName(portfolio.get().getName());
    	return portfolioResponseDto;
 	}

    //Create portfolio
    public PortfolioResponseDto createPortfolio(PortfolioRequestDto request, long userId) {
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found for userId: " + userId);
        }

        // Create and save portfolio
        Portfolio portfolio = new Portfolio();
        portfolio.setName(request.getName());
        portfolio.setUser(user);         // sets user in Portfolio ✅
        user.setPortfolio(portfolio);
        portfolio = portfolioRepository.save(portfolio); // generates portfolioId
        user = userRepository.save(user); // updates user table with portfolioId

        // Prepare response DTO
        PortfolioResponseDto responseDto = new PortfolioResponseDto();
        responseDto.setPortfolioId(portfolio.getPortfolioId());
        responseDto.setName(portfolio.getName());

        return responseDto;
    }

    @Override
    public List<HoldingResponseDto> getHoldingsByPortfolioId(Long portfolioId) {
        List<Holding> holdings = holdingRepository.findAllByPortfolioPortfolioId(portfolioId);
        return holdings.stream()
                .map(h -> new HoldingResponseDto(h.getStockSymbol(), h.getQuantity(), h.getBuyPrice()))
                .collect(Collectors.toList());
    }
    

 	

}    
