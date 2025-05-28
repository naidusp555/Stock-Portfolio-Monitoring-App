package com.bridgelabz.stockportfoliomonitoringapp.repository;

import com.bridgelabz.stockportfoliomonitoringapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository <User,Long>{

}
