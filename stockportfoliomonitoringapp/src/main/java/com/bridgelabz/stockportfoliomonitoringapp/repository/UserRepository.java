
package com.bridgelabz.stockportfoliomonitoringapp.repository;

import com.bridgelabz.stockportfoliomonitoringapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    User findByUserId(Long userId);
    User save(User user);
}

