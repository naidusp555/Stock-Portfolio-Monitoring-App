package com.bridgelabz.stockportfoliomonitoringapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.stockportfoliomonitoringapp.service.HoldingService;

@RestController
@RequestMapping("/api/holdings")
public class HoldingController {
	@Autowired
    private HoldingService holdingservice;
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteHolding(@PathVariable Long id){
		String result = holdingservice.deleteHoldingById(id);
		if(result.equals("Holding not found.")) {
			return ResponseEntity.status(404).body(result);
		}
		return ResponseEntity.ok(result);
	}
}

