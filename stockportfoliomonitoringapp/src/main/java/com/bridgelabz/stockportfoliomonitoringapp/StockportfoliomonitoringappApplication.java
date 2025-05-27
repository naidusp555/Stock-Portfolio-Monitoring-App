package com.bridgelabz.stockportfoliomonitoringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication

public class StockportfoliomonitoringappApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockportfoliomonitoringappApplication.class, args);
	}

}
