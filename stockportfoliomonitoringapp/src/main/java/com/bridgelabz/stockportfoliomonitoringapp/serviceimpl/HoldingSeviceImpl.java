package com.bridgelabz.stockportfoliomonitoringapp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.stockportfoliomonitoringapp.repository.HoldingRepository;
import com.bridgelabz.stockportfoliomonitoringapp.service.HoldingService;

@Service
public class HoldingSeviceImpl implements HoldingService {
	@Autowired
	private HoldingRepository holdingrepository;

	@Override
	public String deleteHoldingById(long id) {
		if(!holdingrepository.existsById(id)){
			return "Holding not found.";
		}
		holdingrepository.deleteById(id);
		return "Holding deleted successfully.";
	}

}
