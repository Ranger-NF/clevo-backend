package com.clevo.wastemanagement.controller;

import com.clevo.wastemanagement.model.Ward;
import com.clevo.wastemanagement.service.WardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class WardController {

    private final WardService wardService;

    public WardController(WardService wardService) {
        this.wardService = wardService;
    }

    @GetMapping("/wards")
    public ResponseEntity<List<Ward>> listWards() {
        return ResponseEntity.ok(wardService.listWards());
    }
}
