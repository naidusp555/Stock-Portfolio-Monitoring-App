package com.bridgelabz.stockportfoliomonitoringapp.dto;

public class PortfolioResponseDto {
    private long portfolioId;
    private String name;


    public PortfolioResponseDto(){}

    public PortfolioResponseDto(long portfolioId, String name, String username) {
        this.portfolioId = portfolioId;
        this.name = name;
    }

    public long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

}
