package com.bridgelabz.stockportfoliomonitoringapp.service;

import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;

public interface HoldingService {
	
	Holding updateHolding(Long id, Holding updatedData);


}
