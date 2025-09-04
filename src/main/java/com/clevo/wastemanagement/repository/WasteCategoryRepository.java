package com.clevo.wastemanagement.repository;

import com.clevo.wastemanagement.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WasteCategoryRepository extends JpaRepository<WasteCategory, UUID> {
}
