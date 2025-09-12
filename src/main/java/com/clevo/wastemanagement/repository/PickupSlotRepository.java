package com.clevo.wastemanagement.repository;

import com.clevo.wastemanagement.model.PickupSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PickupSlotRepository extends JpaRepository<PickupSlot, UUID> {
    // convenient query by recycler id
    List<PickupSlot> findByRecycler_Id(UUID recyclerId);
}
