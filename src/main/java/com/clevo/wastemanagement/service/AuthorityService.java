package com.clevo.wastemanagement.service;

import com.clevo.wastemanagement.dto.WardRequest;
import com.clevo.wastemanagement.dto.WasteCategoryRequest;
import com.clevo.wastemanagement.model.User;
import com.clevo.wastemanagement.model.Ward;
import com.clevo.wastemanagement.model.WasteCategory;
import com.clevo.wastemanagement.repository.UserRepository;
import com.clevo.wastemanagement.repository.WardRepository;
import com.clevo.wastemanagement.repository.WasteCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorityService {

    private final UserRepository userRepository;
    private final WardRepository wardRepository;
    private final WasteCategoryRepository wasteCategoryRepository;

    public AuthorityService(UserRepository userRepository,
                            WardRepository wardRepository,
                            WasteCategoryRepository wasteCategoryRepository) {
        this.userRepository = userRepository;
        this.wardRepository = wardRepository;
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public User changeUserStatus(UUID userId, boolean active) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setActive(active);
        return userRepository.save(user);
    }

    public List<Ward> listWards() {
        return wardRepository.findAll();
    }

    public Ward addWard(WardRequest req) {
        Ward ward = new Ward();
        ward.setName(req.getName());
        ward.setDescription(req.getDescription());
        return wardRepository.save(ward);
    }

    public List<WasteCategory> listWasteCategories() {
        return wasteCategoryRepository.findAll();
    }

    public WasteCategory addWasteCategory(WasteCategoryRequest req) {
        WasteCategory category = new WasteCategory();
        category.setName(req.getName());
        category.setDescription(req.getDescription());
        return wasteCategoryRepository.save(category);
    }

    public Object wasteByRegion() {
        // Temporary sample data for testing
        return java.util.Map.of(
            "Ward 1", 120.5,
            "Ward 2", 98.0
        );
    }

    public Object wasteTrend() {
        // Sample time-series data
        return java.util.List.of(
            java.util.Map.of("date", "2025-09-01", "wasteCollected", 120.0),
            java.util.Map.of("date", "2025-09-02", "wasteCollected", 135.5)
        );
    }

    public Object wasteByType() {
        // Sample breakdown by waste type
        return java.util.Map.of(
            "Plastic", 200.0,
            "Organic", 350.0,
            "Metal", 50.0
        );
    }

    public Object ecoPointsDistribution() {
        // Sample eco-points data
        return java.util.Map.of(
            "totalEarned", 5000,
            "totalRedeemed", 3200
        );
    }
}