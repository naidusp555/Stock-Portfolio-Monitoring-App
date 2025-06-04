package com.bridgelabz.stockportfoliomonitoringapp.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.bridgelabz.stockportfoliomonitoringapp.dto.AlertGetResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.AlertPostRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.AlertPostResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.AlertUpdateRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Alert;

@Service
public interface AlertService {
	public AlertPostResponseDto setAlert( long userId,  AlertPostRequestDto alertPostRequestDto);
	public List<AlertGetResponseDto>  getAllAlert( long userId);
	public Alert updateAlert(long alertId, AlertUpdateRequestDto alertUpdateRequestDto);
}
