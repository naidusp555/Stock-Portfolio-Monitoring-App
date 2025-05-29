

package com.bridgelabz.stockportfoliomonitoringapp.serviceimpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.stockportfoliomonitoringapp.dto.LoginRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.LoginResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.RegisterRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.RegisterResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.User;
import com.bridgelabz.stockportfoliomonitoringapp.exception.EmailAlreadyExistsException;
import com.bridgelabz.stockportfoliomonitoringapp.repository.UserRepository;
import com.bridgelabz.stockportfoliomonitoringapp.service.AuthService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;




@Service
public  class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public RegisterResponseDto registerUser(RegisterRequestDto request) {
		// Check if email is already used
		if (userRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new EmailAlreadyExistsException("Email already in use");//U
		}
		
		//Password Checking
		String pass = request.getPassword();
		String regex = "^[a-zA-Z][a-zA-Z0-9@_.]{5,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(pass);
		if (!matcher.matches()) {
		    throw new IllegalArgumentException("Password does not follow the required format.");
		}
		
		// Create new user
		User user = new User();
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword()); // No encoding
		
		if (user.getEmail() == null || user.getEmail().isBlank()) {
		    throw new IllegalArgumentException("Email must not be null or empty");
		}
		
		// Save user to database
		userRepository.save(user);

		// Create and return responseDTO
	    RegisterResponseDto response = new RegisterResponseDto();
	    response.setMessage("User registered successfully");
	    response.setUsername(request.getUsername());
	    response.setEmail(request.getEmail());
	    response.setRole(null);
	    response.setToken(null);
	    return response;
	}
	
	@Override
	public LoginResponseDto loginUser(LoginRequestDto request) {
		
		Optional<User> user = userRepository.findByEmail(request.getEmail());
		//email check
		if (!user.isPresent()) {
			throw new RuntimeException("Email is not registered");
		}
		
		//password check
		 if (!user.get().getPassword().equals(request.getPassword())) {
		        throw new RuntimeException("Incorrect password");
		    }
		 
		// Generate JWT token
		String token = null;
		
		//create response
		LoginResponseDto response = new LoginResponseDto();
		response.setMessage("You have successfully logged in.");
		response.setUserName(user.get().getUsername());
		response.setEmail(user.get().getEmail());
		response.setToken(token);
		
		return response;
		
	}
}
