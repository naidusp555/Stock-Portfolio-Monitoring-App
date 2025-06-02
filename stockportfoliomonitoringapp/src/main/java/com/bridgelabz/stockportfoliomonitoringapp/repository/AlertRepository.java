package com.bridgelabz.stockportfoliomonitoringapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.bridgelabz.stockportfoliomonitoringapp.entity.Alert;

public interface AlertRepository extends JpaRepository<Alert, Long> {
	
	List<Alert> findByUserUserId(Long userId);
	


}
