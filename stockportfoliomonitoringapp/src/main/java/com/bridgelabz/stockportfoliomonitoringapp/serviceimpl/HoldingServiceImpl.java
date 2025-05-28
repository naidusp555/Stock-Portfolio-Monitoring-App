package com.bridgelabz.stockportfoliomonitoringapp.serviceimpl;



import java.util.Optional;




import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Portfolio;
import com.bridgelabz.stockportfoliomonitoringapp.repository.HoldingRepository;
import com.bridgelabz.stockportfoliomonitoringapp.repository.PortfolioRepository;
import com.bridgelabz.stockportfoliomonitoringapp.service.HoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoldingServiceImpl implements HoldingService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private HoldingRepository holdingRepository;

    @Override
    public HoldingResponseDto addHolding(Long portfolioId, String stockSymbol, int quantity, double buyPrice) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        Holding holding = new Holding();
        holding.setPortfolio(portfolio);
        holding.setStockSymbol(stockSymbol);
        holding.setQuantity(quantity);
        holding.setBuyPrice(buyPrice);

        Holding saved = holdingRepository.save(holding);

        HoldingResponseDto response = new HoldingResponseDto(stockSymbol, quantity, buyPrice);
        response.setStockSymbol(saved.getStockSymbol());
        response.setQuantity(saved.getQuantity());
        response.setBuyPrice(saved.getBuyPrice());

        return response;
    }
  
    @Override
    public Holding updateHolding(Long id, Holding updatedData) {
        Optional<Holding> optionalHolding = holdingRepository.findById(id);
        if (optionalHolding.isEmpty()) {
            throw new RuntimeException("Holding not found");
        }

        Holding olddataHolding = optionalHolding.get();

        int oldQuantity = olddataHolding.getQuantity();
        int newQuantity = updatedData.getQuantity();
        double newPrice = updatedData.getBuyPrice();

        int totalQuantity = oldQuantity + newQuantity;

        olddataHolding.setQuantity(totalQuantity);
        olddataHolding.setBuyPrice(newPrice);

        return holdingRepository.save(olddataHolding);
    }


}
