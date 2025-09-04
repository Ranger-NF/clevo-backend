package com.clevo.wastemanagement.repository;

import com.clevo.wastemanagement.model.PickupSlot;
import com.clevo.wastemanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PickupSlotRepository extends JpaRepository<PickupSlot, UUID> {
    List<PickupSlot> findByRecycler(User recycler);
}
