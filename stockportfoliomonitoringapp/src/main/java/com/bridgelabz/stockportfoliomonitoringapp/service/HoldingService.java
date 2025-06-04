package com.bridgelabz.stockportfoliomonitoringapp.service;

import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingResponseDto;

public interface HoldingService {
	HoldingResponseDto addHolding(HoldingRequestDto request);
	HoldingResponseDto updateHolding(long holdingId, HoldingRequestDto holdingRequestDto);
	String deleteHoldingById(long holdingId);

}
