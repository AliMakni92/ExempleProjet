package com.exemple.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.User;
import com.exemple.IRepository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public User registerUser(User user) {
        // Validate user input and enforce rules
        if (!isAdultFrenchResident(user)) {
            throw new IllegalArgumentException("Only adult French residents are allowed to create an account.");
        }
        
        // Save the user to the database
        return userRepository.save(user);
    }
    
    private boolean isAdultFrenchResident(User user) {
        // Implement logic to check if the user is an adult French resident
        // You may use external services or data sources for this validation
        return true; // Placeholder logic
    }
}

