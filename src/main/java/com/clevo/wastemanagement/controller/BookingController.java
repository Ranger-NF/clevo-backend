package com.clevo.wastemanagement.controller;

import com.clevo.wastemanagement.dto.UpdateBookingStatusRequest;
import com.clevo.wastemanagement.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/recycler/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // ✅ Update booking status API
    @PutMapping("/{bookingId}/status")
    public ResponseEntity<String> updateBookingStatus(
            @PathVariable UUID bookingId,
            @RequestBody UpdateBookingStatusRequest request) {

        bookingService.updateBookingStatus(bookingId, request.getStatus());
        return ResponseEntity.ok("Booking status updated to " + request.getStatus());
    }
}
