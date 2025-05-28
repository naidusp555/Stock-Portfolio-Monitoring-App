package com.bridgelabz.stockportfoliomonitoringapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;
import com.bridgelabz.stockportfoliomonitoringapp.service.HoldingService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

	



@RestController
@RequestMapping("/api/holdings")
public class HoldingController {

    @Autowired
    private HoldingService holdingService;

    @PostMapping("/add")
    public ResponseEntity<HoldingResponseDto> addHolding(@RequestBody HoldingRequest request) {
        HoldingResponseDto response = holdingService.addHolding(
                request.getPortfolioId(),
                request.getStockSymbol(),
                request.getQuantity(),
                request.getBuyPrice()
        );
        return ResponseEntity.ok(response);
    }
  
@PutMapping("/{id}")
	public ResponseEntity<Holding> updateHolding(@PathVariable long id,@RequestBody Holding updatedData){
		Holding updated = holdingService.updateHolding(id, updatedData);
	    return ResponseEntity.ok(updated);
	}
    
    public static class HoldingRequest {
        public Long getPortfolioId() {
			return portfolioId;
		}
		public void setPortfolioId(Long portfolioId) {
			this.portfolioId = portfolioId;
		}
		public String getStockSymbol() {
			return stockSymbol;
		}
		public void setStockSymbol(String stockSymbol) {
			this.stockSymbol = stockSymbol;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getBuyPrice() {
			return buyPrice;
		}
		public void setBuyPrice(double buyPrice) {
			this.buyPrice = buyPrice;
		}
		private Long portfolioId;
        private String stockSymbol;
        private int quantity;
        private double buyPrice;

    }

}
