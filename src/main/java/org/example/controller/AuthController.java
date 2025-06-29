package org.example.controller;
import org.example.model.AppUser;
import org.example.repository.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController

public class AuthController {

    @Autowired
    private AppUserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/public/register")
    public ResponseEntity<String> register(@RequestBody AppUser user) {
        // Check if the username already exists
        if (userRepo.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body("Username already exists!");
        }

        // Encode the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Assign default role
        user.setRole("ROLE_USER");

        // Save user to database
        userRepo.save(user);

        return ResponseEntity.ok("User registered successfully!");
    }
}
