package com.clevo.wastemanagement.service;

import org.springframework.stereotype.Service;





import com.clevo.wastemanagement.dto.RegisterRequest;
import com.clevo.wastemanagement.model.User;
import com.clevo.wastemanagement.model.Ward;
import com.clevo.wastemanagement.repository.UserRepository;
import com.clevo.wastemanagement.repository.WardRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class AuthService {

    private final UserRepository userRepo;
    private final WardRepository wardRepo;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepo,
                       WardRepository wardRepo,
                       PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.wardRepo = wardRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerCitizenAware(RegisterRequest req) {
        if (req.getRole() == User.Role.CITIZEN && req.getWardId() == null) {
            throw new IllegalArgumentException("Citizen must provide a wardId");
        }

        User.UserBuilder builder = User.builder()
                .username(req.getUsername())
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .role(req.getRole())
                .firstName(req.getFirstName())
                .lastName(req.getLastName())
                .address(req.getAddress())
                .phoneNumber(req.getPhoneNumber())
                .active(true);

        // attach Ward only for citizens
        if (req.getRole() == User.Role.CITIZEN) {
            Ward ward = wardRepo.findById(req.getWardId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid wardId"));
            builder.ward(ward);
        }

        return userRepo.save(builder.build());
    }
}

