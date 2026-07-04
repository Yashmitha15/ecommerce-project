package com.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        // Security check: Make sure username isn't taken
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username is already taken!");
        }
        
        // Save the user credentials to database
        userRepository.save(user);
        return ResponseEntity.ok("Registration successful!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        
        // Check if user exists and if password perfectly matches
        if (existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok("Welcome back, " + user.getUsername() + "!");
        }
        
        return ResponseEntity.status(401).body("Invalid username or password!");
    }
}