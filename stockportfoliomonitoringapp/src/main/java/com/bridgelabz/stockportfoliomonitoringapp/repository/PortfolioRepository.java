package com.bridgelabz.stockportfoliomonitoringapp.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Portfolio;


public interface PortfolioRepository extends JpaRepository<Portfolio,Integer>{

	Optional<Portfolio> findById(Long portfolioId);

}
