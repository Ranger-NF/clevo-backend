package com.clevo.wastemanagement.controller;

import com.clevo.wastemanagement.dto.WardRequest;
import com.clevo.wastemanagement.dto.WasteCategoryRequest;
import com.clevo.wastemanagement.model.User;
import com.clevo.wastemanagement.model.Ward;
import com.clevo.wastemanagement.model.WasteCategory;
import com.clevo.wastemanagement.service.AuthorityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/authority")
public class AuthorityController {

    private final AuthorityService authorityService;

    public AuthorityController(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok(authorityService.listUsers());
    }

    @PutMapping("/users/{id}/activate")
    public ResponseEntity<User> activateUser(@PathVariable UUID id) {
        return ResponseEntity.ok(authorityService.changeUserStatus(id, true));
    }

    @PutMapping("/users/{id}/deactivate")
    public ResponseEntity<User> deactivateUser(@PathVariable UUID id) {
        return ResponseEntity.ok(authorityService.changeUserStatus(id, false));
    }

    @GetMapping("/wards")
    public ResponseEntity<List<Ward>> listWards() {
        return ResponseEntity.ok(authorityService.listWards());
    }

    @PostMapping("/wards")
    public ResponseEntity<Ward> addWard(@RequestBody WardRequest req) {
        return ResponseEntity.ok(authorityService.addWard(req));
    }

    @GetMapping("/waste-categories")
    public ResponseEntity<List<WasteCategory>> listWasteCategories() {
        return ResponseEntity.ok(authorityService.listWasteCategories());
    }

    @PostMapping("/waste-categories")
    public ResponseEntity<WasteCategory> addWasteCategory(@RequestBody WasteCategoryRequest req) {
        return ResponseEntity.ok(authorityService.addWasteCategory(req));
    }

    @GetMapping("/dashboard/waste-by-region")
    public ResponseEntity<?> wasteByRegion() {
        return ResponseEntity.ok(authorityService.wasteByRegion());
    }

    @GetMapping("/dashboard/waste-trend")
    public ResponseEntity<?> wasteTrend() {
        return ResponseEntity.ok(authorityService.wasteTrend());
    }

    @GetMapping("/dashboard/waste-by-type")
    public ResponseEntity<?> wasteByType() {
        return ResponseEntity.ok(authorityService.wasteByType());
    }

    @GetMapping("/dashboard/eco-points-distribution")
    public ResponseEntity<?> ecoPointsDistribution() {
        return ResponseEntity.ok(authorityService.ecoPointsDistribution());
    }
}