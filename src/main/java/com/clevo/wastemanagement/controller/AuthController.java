package com.clevo.wastemanagement.controller;

import com.clevo.wastemanagement.dto.*;
import com.clevo.wastemanagement.model.User;
import com.clevo.wastemanagement.repository.UserRepository;
import com.clevo.wastemanagement.security.JwtUtil;
import com.clevo.wastemanagement.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final AuthService authService;


    public AuthController(UserRepository userRepository,    AuthenticationManager authenticationManager, JwtUtil jwtUtil, AuthService authService) {
        this.userRepository = userRepository;

        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        // 1. basic uniqueness check (keep this)
        System.out.println(req);
        if (userRepository.findByUsername(req.getUsername()).isPresent() ||
                userRepository.findByEmail(req.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Username or email already exists");
        }

        // 2. delegate the actual save/validation to AuthService
        try {
            User user = authService.registerCitizenAware(req);
            return ResponseEntity.ok("User registered successfully with id " + user.getId());
        } catch (IllegalArgumentException ex) {
            // e.g. missing/invalid wardId for citizen
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())
            );
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
        User user = userRepository.findByUsername(req.getUsername()).orElseThrow();
        String token = jwtUtil.generateToken(user.getUsername(), user.getRole().name());
        return ResponseEntity.ok(Map.of(
            "token", token,
            "role", user.getRole().name(),
            "username", user.getUsername()
        ));
    }
}
