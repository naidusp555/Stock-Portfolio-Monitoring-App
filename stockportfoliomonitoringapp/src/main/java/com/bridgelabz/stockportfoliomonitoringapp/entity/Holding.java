package com.bridgelabz.stockportfoliomonitoringapp.entity;

import jakarta.persistence.*;

@Entity
public class Holding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long holdingId;

    private String stockSymbol;
    private int quantity;
    private double buyPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolioId;

    public Holding() {
        super();
    }

    public Holding(long id, String stockSymbol, int quantity, double buyPrice, Portfolio portfolio) {
        this.holdingId = id;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
        this.portfolioId = portfolio;
    }

    public long getId() {
        return holdingId;
    }

    public void setId(long id) {
        this.holdingId = id;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Portfolio getPortfolio() {
        return portfolioId;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolioId = portfolio;
    }

    @Override
    public String toString() {
        return "Holding [id=" + holdingId + ", stockSymbol=" + stockSymbol + ", quantity=" + quantity +
                ", buyPrice=" + buyPrice + ", portfolio=" + (portfolioId != null ? portfolioId.getId() : null) + "]";
    }
}
