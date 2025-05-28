package com.bridgelabz.stockportfoliomonitoringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.bridgelabz.stockportfoliomonitoringapp","com.bridgelabz.stockportfoliomonitoringapp.dto"})
public class StockportfoliomonitoringappApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockportfoliomonitoringappApplication.class, args);
	}

}
