package com.bridgelabz.stockportfoliomonitoringapp.util;

import java.util.List;

import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioReportLogResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;

public class GainLossCalculator {
	public static PortfolioReportLogResponseDto calculate(List<Holding> holdings) {
		
		double totalValue = 0.0;
		double currentValue = 0.0;
		
		for(Holding holding:holdings) {
			totalValue += holding.getBuyPrice()*holding.getQuantity();
			double fluctuationFactor = 0.90 + (Math.random()*0.20);
			double marketPrice = holding.getBuyPrice()*fluctuationFactor;
			currentValue += holding.getQuantity()*marketPrice;
		}
		
		double totalGainLoss = currentValue - totalValue;
		double percentReturn = totalValue == 0 ? 0:(totalGainLoss/totalValue)*100;
		return new PortfolioReportLogResponseDto(totalValue, totalGainLoss, percentReturn);
	}
}