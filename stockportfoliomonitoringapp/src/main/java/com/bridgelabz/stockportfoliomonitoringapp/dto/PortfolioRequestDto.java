package com.bridgelabz.stockportfoliomonitoringapp.dto;

import jakarta.validation.constraints.NotBlank;

public class PortfolioRequestDto {
    @NotBlank(message = "Portfolio name is mandatory")
    private String name;
    public PortfolioRequestDto(){

    }
    public PortfolioRequestDto(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
