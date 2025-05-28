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
@RequestMapping("/api")
public class HoldingController {
private HoldingService holdingService;
	
	@PutMapping("holdings/{id}")
	public ResponseEntity<Holding> updateHolding(@PathVariable long id,@RequestBody Holding updatedData){
		Holding updated = holdingService.updateHolding(id, updatedData);
	    return ResponseEntity.ok(updated);
	}

}
