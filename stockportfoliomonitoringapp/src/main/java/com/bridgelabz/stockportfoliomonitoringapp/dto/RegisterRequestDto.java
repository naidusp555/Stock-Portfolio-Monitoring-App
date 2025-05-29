package com.bridgelabz.stockportfoliomonitoringapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class RegisterRequestDto {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

 
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9@_.]{5,}$", message = "Password Should start with alphabets and it should have ")
    @NotBlank(message = "Password is required")
    private String password;

    public RegisterRequestDto() {
        // No-args constructor
    }

    public RegisterRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
