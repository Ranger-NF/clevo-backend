package com.clevo.wastemanagement.repository;

import com.clevo.wastemanagement.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {
    List<Booking> findByPickupSlot_Ward_Id(UUID wardId);
    List<Booking> findByCitizen_Id(UUID citizenId);
}
