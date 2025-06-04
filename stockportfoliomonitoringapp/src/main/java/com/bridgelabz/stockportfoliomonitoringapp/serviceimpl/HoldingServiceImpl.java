package com.bridgelabz.stockportfoliomonitoringapp.serviceimpl;



import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Portfolio;
import com.bridgelabz.stockportfoliomonitoringapp.repository.HoldingRepository;
import com.bridgelabz.stockportfoliomonitoringapp.repository.PortfolioRepository;
import com.bridgelabz.stockportfoliomonitoringapp.service.HoldingService;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoldingServiceImpl implements HoldingService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private HoldingRepository holdingRepository;
    
    @Override
    public HoldingResponseDto addHolding(HoldingRequestDto request) {
    	if (request.getPortfolioId() == null) {
            throw new IllegalArgumentException("Portfolio ID must not be null");
        }
        Portfolio portfolio = portfolioRepository.findById(request.getPortfolioId())
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        Holding holding = new Holding();
        holding.setPortfolio(portfolio);
        holding.setStockSymbol(request.getStockSymbol());
        holding.setQuantity(request.getQuantity());
        holding.setBuyPrice(request.getBuyPrice());

        Holding saved = holdingRepository.save(holding);

        HoldingResponseDto response = new HoldingResponseDto();
        response.setStockSymbol(saved.getStockSymbol());
        response.setQuantity(saved.getQuantity());
        response.setBuyPrice(saved.getBuyPrice());

        return response;
    }

    
    //Updation of Holding
    @Override
    public HoldingResponseDto updateHolding(long holdingId, HoldingRequestDto holdingRequestDto){
        Optional<Holding> holding = holdingRepository.findById(holdingId);
        if (!holding.isPresent()) {
            throw new RuntimeException("Holding not found");
        }

        Holding oldDataHolding = holding.get();

        int oldQuantity = oldDataHolding.getQuantity();
        int newQuantity = holdingRequestDto.getQuantity();
        double newPrice = holdingRequestDto.getBuyPrice();

        int totalQuantity = oldQuantity + newQuantity;

        oldDataHolding.setQuantity(totalQuantity);
        oldDataHolding.setBuyPrice(newPrice);
        holdingRepository.save(oldDataHolding);
        
        HoldingResponseDto holdingResponseDto = new HoldingResponseDto();
        holdingResponseDto.setBuyPrice(newPrice);
        holdingResponseDto.setQuantity(totalQuantity);
        holdingResponseDto.setStockSymbol(holdingRequestDto.getStockSymbol());;

        return holdingResponseDto;
    }

    
    //Deletion of holding
	@Override
	public String deleteHoldingById(long holdingId) {
		if(!holdingRepository.existsById(holdingId)){
			return "Holding not found.";
		}
		holdingRepository.deleteById(holdingId);
		return "Holding deleted successfully.";
	}

    


}
