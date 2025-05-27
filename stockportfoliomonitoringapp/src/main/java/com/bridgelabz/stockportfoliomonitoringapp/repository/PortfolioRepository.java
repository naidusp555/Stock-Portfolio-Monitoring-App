package com.bridgelabz.stockportfoliomonitoringapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Portfolio;


public interface PortfolioRepository extends JpaRepository<Portfolio,Integer>{

}
