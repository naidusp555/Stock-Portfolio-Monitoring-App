package com.bridgelabz.stockportfoliomonitoringapp;

import com.bridgelabz.stockportfoliomonitoringapp.controller.HoldingController;
import com.bridgelabz.stockportfoliomonitoringapp.service.HoldingService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class StockportfoliomonitoringappApplicationTests {
	@Mock
	private HoldingService holdingService;

	@InjectMocks
	private HoldingController holdingController;

	@Test
	public void testDeleteHolding_Success() {
		Long holdingId = 1L;
		String successMessage = "Holding deleted successfully.";

		when(holdingService.deleteHoldingById(holdingId)).thenReturn(successMessage);

		ResponseEntity<String> response = holdingController.deleteHolding(holdingId);

		assertEquals(200, response.getStatusCodeValue());
		assertEquals(successMessage, response.getBody());
	}

	@Test
	public void testDeleteHolding_NotFound() {
		Long holdingId = 999L;
		String errorMessage = "Holding not found.";

		when(holdingService.deleteHoldingById(holdingId)).thenReturn(errorMessage);

		ResponseEntity<String> response = holdingController.deleteHolding(holdingId);

		assertEquals(404, response.getStatusCodeValue());
		assertEquals(errorMessage, response.getBody());
	}

}
