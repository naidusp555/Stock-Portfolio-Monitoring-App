package com.bridgelabz.stockportfoliomonitoringapp.repository;

import com.bridgelabz.stockportfoliomonitoringapp.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PortfolioRepository extends JpaRepository<Portfolio,Long> {
    Optional<Portfolio>findById(long portfolioId);

}
