package com.clevo.wastemanagement.repository;

import com.clevo.wastemanagement.model.PickupSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPickupSlotRepository extends JpaRepository<PickupSlot, Long> {
}