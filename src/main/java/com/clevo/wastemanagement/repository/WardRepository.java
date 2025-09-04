package com.clevo.wastemanagement.repository;

import com.clevo.wastemanagement.model.Ward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WardRepository extends JpaRepository<Ward, UUID> {
}
