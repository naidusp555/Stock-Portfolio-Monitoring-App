package com.bridgelabz.stockportfoliomonitoringapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.stockportfoliomonitoringapp.dto.AlertGetResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.AlertPostRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.AlertPostResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.AlertUpdateRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Alert;
import com.bridgelabz.stockportfoliomonitoringapp.service.AlertService;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {
	
	@Autowired
	AlertService alertService;
	
	@PostMapping("{userId}")
	public ResponseEntity<AlertPostResponseDto> setAlert(@PathVariable long userId, @RequestBody AlertPostRequestDto alertPostRequestDto){
		
		AlertPostResponseDto alertPostResponseDto = alertService.setAlert(userId, alertPostRequestDto);
		
		return new ResponseEntity<AlertPostResponseDto>(alertPostResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<AlertGetResponseDto>> getAllAlert(@PathVariable long userId){
		List<AlertGetResponseDto> alertGetResponseDto = alertService.getAllAlert(userId);
		return new ResponseEntity<List<AlertGetResponseDto>>(alertGetResponseDto, HttpStatus.OK);
	}
	
	@PutMapping("/{alertId}")
	public ResponseEntity<Alert> updateAlert(@PathVariable long alertId, @RequestBody AlertUpdateRequestDto alertUpdateRequestDto){
		Alert updatedAlert = alertService.updateAlert(alertId, alertUpdateRequestDto);
		return new ResponseEntity<>(updatedAlert, HttpStatus.OK);
	}
	

}
