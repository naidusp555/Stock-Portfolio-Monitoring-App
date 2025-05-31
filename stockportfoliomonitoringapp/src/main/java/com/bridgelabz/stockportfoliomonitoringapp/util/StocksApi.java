package com.bridgelabz.stockportfoliomonitoringapp.util;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;


@Component
public class StocksApi {
	
	
	
//	@Scheduled(fixedDelay = 2000)
	void fetchStockPrice() throws Exception {
		
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create("https://stock.indianapi.in/stock?name=sbin"))
			    .header("X-Api-Key", "sk-live-qRr66nuYjV8fb2aizxdo3RW1eXl1KDEw5p9GDrj3")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
	}

}
