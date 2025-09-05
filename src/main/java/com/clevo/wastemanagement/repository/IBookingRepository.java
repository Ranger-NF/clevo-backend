package com.clevo.wastemanagement.repository;
import com.clevo.wastemanagement.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingRepository extends JpaRepository<Booking, Long> {
}
