package com.bridgelabz.stockportfoliomonitoringapp.serviceimpl;

import com.bridgelabz.stockportfoliomonitoringapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.stockportfoliomonitoringapp.dto.AuthRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.AuthResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.repository.UserRepository;
import com.bridgelabz.stockportfoliomonitoringapp.service.AuthService;


@Service
public abstract class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public AuthResponseDto registerUser(AuthRequestDto request) {
        // Check if email is already used
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        // Create new user
        User user = new User();

        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // No encoding

        // Save user to database
        userRepository.save(user);

        // Return success response
        return new AuthResponseDto("User registered successfully");
    }
}
