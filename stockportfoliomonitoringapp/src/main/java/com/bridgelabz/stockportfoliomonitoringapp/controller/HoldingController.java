package com.bridgelabz.stockportfoliomonitoringapp.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;
import com.bridgelabz.stockportfoliomonitoringapp.service.HoldingService;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/api/holdings")
public class HoldingController {

	@Autowired
	private HoldingService holdingService;
	
	//add holdings
	@PostMapping("/add")
	public ResponseEntity<HoldingResponseDto> addHolding(@RequestBody HoldingRequestDto request) {
		HoldingResponseDto response = holdingService.addHolding(request);
		return new ResponseEntity<HoldingResponseDto>(response, HttpStatus.OK);
	}


	//update holdings
	@PutMapping("/{holdingId}")
	public ResponseEntity<HoldingResponseDto> updateHolding(@PathVariable long holdingId, @RequestBody HoldingRequestDto holdingRequestDto){
		HoldingResponseDto updated = holdingService.updateHolding(holdingId, holdingRequestDto);
		return new ResponseEntity<HoldingResponseDto>(updated, HttpStatus.OK);
	}
	
	//Delection of holdings
	@DeleteMapping("/{holdingId}")
	public ResponseEntity<String> deleteHolding(@PathVariable Long holdingId){
		String result = holdingService.deleteHoldingById(holdingId);
		if(result.equals("Holding not found.")) {
			return ResponseEntity.status(404).body(result);
		}
		return ResponseEntity.ok(result);
	}




	

}
