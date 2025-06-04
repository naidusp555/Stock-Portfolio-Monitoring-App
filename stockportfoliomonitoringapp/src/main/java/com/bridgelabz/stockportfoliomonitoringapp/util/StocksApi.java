package com.bridgelabz.stockportfoliomonitoringapp.util;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;


@Component
public class StocksApi {
	
	
	
//	@Scheduled(fixedDelay = 2000)
	public double fetchStockPrice(String stockSymbol) throws Exception {
		
		 HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create("https://stock.indianapi.in/stock?name=" + stockSymbol))
	                .header("X-Api-Key", "sk-live-zcgVbyHJVUpp4uEhVDWh2vI9xm1qEypSB4V28JD9")
	                .method("GET", HttpRequest.BodyPublishers.noBody())
	                .build();
	        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
	        String jsonBody=response.body();
	      
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode z=mapper.readTree(jsonBody);

	        double price= z.get("currentPrice").get("NSE").asDouble();


	        return price;
	}

}
