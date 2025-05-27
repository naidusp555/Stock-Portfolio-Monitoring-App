package com.bridgelabz.stockportfoliomonitoringapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class WebConfig {
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Stock Portfolio Monitoring App")
                .version("1.0.0")
                .description("API documentation for my Stock Portfolio Monitoring App"));
    }
}
