package com.bridgelabz.stockportfoliomonitoringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StockportfoliomonitoringappApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockportfoliomonitoringappApplication.class, args);
	}

}
