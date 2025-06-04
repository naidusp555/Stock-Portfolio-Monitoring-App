package com.bridgelabz.stockportfoliomonitoringapp.serviceimpl;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import com.bridgelabz.stockportfoliomonitoringapp.dto.AlertGetResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.AlertPostRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.AlertPostResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.AlertUpdateRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Alert;
import com.bridgelabz.stockportfoliomonitoringapp.entity.User;
import com.bridgelabz.stockportfoliomonitoringapp.exception.UserNotFoundException;
import com.bridgelabz.stockportfoliomonitoringapp.repository.AlertRepository;
import com.bridgelabz.stockportfoliomonitoringapp.repository.UserRepository;
import com.bridgelabz.stockportfoliomonitoringapp.service.AlertService;
import com.bridgelabz.stockportfoliomonitoringapp.util.SendMail;
import com.bridgelabz.stockportfoliomonitoringapp.util.StocksApi;

@Service
public class AlertServiceImpl implements AlertService{
	
	@Autowired
	AlertRepository alertRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
    JavaMailSender mailSender;
	
	@Autowired
	MailServiceImpl mailServiceImpl;
	
	@Autowired
	StocksApi stocksApi;
	
	//set alert
	public AlertPostResponseDto setAlert(long userId, AlertPostRequestDto alertPostRequestDto) {
		
		Optional<User> user = userRepository.findById(userId);
		if(user.isEmpty()){
			throw new UserNotFoundException("User does not exist");
		}
		Alert alert = new Alert();
		alert.setStockSymbol(alertPostRequestDto.getStockSymbol());
		alert.setPriceThreshold(alertPostRequestDto.getPriceThreshold());
		alert.setPortfolioLossPercentage(0);
		alert.setTriggered(false);
		alert.setUser(user.get());
		
		Alert alertSaved = alertRepository.save(alert);
		
		AlertPostResponseDto alertPostResponseDto = new AlertPostResponseDto(alertSaved.getStockSymbol(), alertSaved.getPriceThreshold());
		return alertPostResponseDto;
	}
	
	
	//Fetch Alerts
	public List<AlertGetResponseDto> getAllAlert(long userId) {
	    Optional<User> user = userRepository.findById(userId);
	    if (user.isEmpty()) {
	        throw new UserNotFoundException("User does not exist");
	    }

	    List<Alert> alertList = alertRepository.findByUserUserId(userId);
	    List<AlertGetResponseDto> alertGetResponseDtoList = new ArrayList<>();

	    for (Alert x : alertList) {
	        AlertGetResponseDto alertGetResponseDto = new AlertGetResponseDto(); // Moved inside loop
	        alertGetResponseDto.setAlertId(x.getAlertId());
	        alertGetResponseDto.setStockSymbol(x.getStockSymbol());
	        alertGetResponseDto.setPriceThreshold(x.getPriceThreshold());
	        alertGetResponseDto.setPortfolioLossPercentage(x.getPortfolioLossPercentage());
	        alertGetResponseDto.setTriggered(x.isTriggered());
	        alertGetResponseDtoList.add(alertGetResponseDto);
	    }

	    return alertGetResponseDtoList;
	}
	
	//update alert
	public Alert updateAlert(long alertId, AlertUpdateRequestDto alertUpdateRequestDto) {
		Optional<Alert> optionalAlert = alertRepository.findById(alertId);
		if (optionalAlert.isEmpty()) {
	        throw new UserNotFoundException("User does not exist");
	    }
		
		Alert alert = optionalAlert.get();
		
		if(alertUpdateRequestDto.getPortfolioLossPercentage() != null) {
			alert.setPortfolioLossPercentage(alertUpdateRequestDto.getPortfolioLossPercentage());
		}
		
		if(alertUpdateRequestDto.getPriceThreshold() != null) {
			alert.setPriceThreshold(alertUpdateRequestDto.getPriceThreshold());
		}
		 
		Alert updatedAlert = alertRepository.save(alert);
		
		return updatedAlert;
	}
	
	
	//Sending alertMail to any User
//	@Scheduled(fixedDelay = 2000)
	public void alertMail() {
	    List<Alert> log = alertRepository.findAll();

	    for (Alert alert : log) {
	        try {
	            if (alert.isTriggered()) continue; 

	            double currentPrice = stocksApi.fetchStockPrice(alert.getStockSymbol());
	            double boughtPrice = alert.getPriceThreshold();

	            if (currentPrice > boughtPrice) {
	                User user = alert.getUser();
	                String body = "Alert! The price of " + alert.getStockSymbol() + 
	                              " is now ₹" + currentPrice + 
	                              ", above your threshold ₹" + boughtPrice;
	                sendEmail(user.getEmail(), "Stock Alert Triggered!", body);
	                
	                alert.setTriggered(true);
	                alertRepository.save(alert);
	            }
	        } catch (Exception e) {
	            // Log error
	            System.err.println("Error processing alert for " + alert.getStockSymbol());
	        }
	    }
	}

	
	public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("naidusp555@gmail.com");  
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

}
