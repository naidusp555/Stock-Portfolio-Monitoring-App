
package com.bridgelabz.stockportfoliomonitoringapp.repository;

import com.bridgelabz.stockportfoliomonitoringapp.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface PortfolioRepository extends JpaRepository<Portfolio,Long> {
    List<Portfolio> findByUserId(Long userId);
}

