
package com.bridgelabz.stockportfoliomonitoringapp.repository;

import com.bridgelabz.stockportfoliomonitoringapp.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio,Long> {
   
}

