package com.bridgelabz.stockportfoliomonitoringapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;


public interface HoldingRepository extends JpaRepository<Holding,Integer>{

}
