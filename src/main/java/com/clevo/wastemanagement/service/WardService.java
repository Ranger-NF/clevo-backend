package com.clevo.wastemanagement.service;

import com.clevo.wastemanagement.model.Ward;
import com.clevo.wastemanagement.repository.WardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardService {
    private final WardRepository wardRepository;

    public WardService(WardRepository wardRepo) {
        this.wardRepository = wardRepo;
    }

    public List<Ward> listWards() {
        return wardRepository.findAll();
    }
}
