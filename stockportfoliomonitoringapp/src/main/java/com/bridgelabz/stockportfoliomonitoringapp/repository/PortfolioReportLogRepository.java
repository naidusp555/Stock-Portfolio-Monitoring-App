package com.bridgelabz.stockportfoliomonitoringapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;
import com.bridgelabz.stockportfoliomonitoringapp.entity.PortfolioReportLog;
@Repository
public interface PortfolioReportLogRepository extends JpaRepository<PortfolioReportLog, Long> {
	List<PortfolioReportLog> findAllByPortfolioPortfolioId(long portfolioId);
}
