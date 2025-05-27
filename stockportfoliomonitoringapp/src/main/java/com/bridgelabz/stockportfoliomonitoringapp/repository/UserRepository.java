package com.bridgelabz.stockportfoliomonitoringapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bridgelabz.stockportfoliomonitoringapp.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
