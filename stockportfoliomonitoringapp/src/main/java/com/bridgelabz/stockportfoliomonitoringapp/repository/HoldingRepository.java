package com.bridgelabz.stockportfoliomonitoringapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;

@Repository
public interface HoldingRepository extends JpaRepository<Holding, Long> {
    List<Holding> findHoldingByPortfolioId(Long portfolioId);
}
