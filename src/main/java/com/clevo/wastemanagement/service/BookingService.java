package com.clevo.wastemanagement.service;

import com.clevo.wastemanagement.model.Booking;
import com.clevo.wastemanagement.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public void updateBookingStatus(UUID bookingId, String status) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus(Booking.Status.valueOf(status.toUpperCase())); // e.g. CONFIRMED, CANCELLED
        bookingRepository.save(booking);
    }
}
