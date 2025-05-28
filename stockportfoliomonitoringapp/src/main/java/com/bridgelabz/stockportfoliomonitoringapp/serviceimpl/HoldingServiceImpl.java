package com.bridgelabz.stockportfoliomonitoringapp.serviceimpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;
import com.bridgelabz.stockportfoliomonitoringapp.repository.HoldingRepository;
import com.bridgelabz.stockportfoliomonitoringapp.service.HoldingService;

@Service
public class HoldingServiceImpl implements HoldingService{

	@Autowired
    private HoldingRepository holdingRepository;

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
