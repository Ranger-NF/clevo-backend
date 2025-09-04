package com.clevo.wastemanagement.controller;
import com.clevo.wastemanagement.dto.UpdateBookingStatusRequest;
import com.clevo.wastemanagement.service.BookingService;
import com.clevo.wastemanagement.model.Booking;
import com.clevo.wastemanagement.model.PickupSlot;
import com.clevo.wastemanagement.service.RecyclerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/recycler")
public class RecyclerController {

    private final RecyclerService recyclerService;
    private final BookingService bookingService;
    public RecyclerController(RecyclerService recyclerService, BookingService bookingService) {
        this.recyclerService = recyclerService;
        this.bookingService = bookingService;
    }


    // GET recycler slots
    @GetMapping("/slots/{recyclerId}")
    public ResponseEntity<List<PickupSlot>> getRecyclerSlots(@PathVariable UUID recyclerId) {
        return ResponseEntity.ok(recyclerService.getRecyclerSlots(recyclerId));
    }

    // POST create slot
    @PostMapping("/slots")
    public ResponseEntity<PickupSlot> createSlot(@RequestBody PickupSlot slot) {
        return ResponseEntity.ok(recyclerService.createSlot(slot));
    }

    // PUT update slot
    @PutMapping("/slots/{id}")
    public ResponseEntity<PickupSlot> updateSlot(@PathVariable UUID id, @RequestBody PickupSlot slot) {
        return ResponseEntity.ok(recyclerService.updateSlot(id, slot));
    }

    // DELETE slot
    @DeleteMapping("/slots/{id}")
    public ResponseEntity<Void> deleteSlot(@PathVariable UUID id) {
        recyclerService.deleteSlot(id);
        return ResponseEntity.noContent().build();
    }

    // GET bookings for ward
    @GetMapping("/bookings/ward/{wardId}")
    public ResponseEntity<List<Booking>> getBookingsByWard(@PathVariable UUID wardId) {
        return ResponseEntity.ok(recyclerService.getBookingsByWard(wardId));
    }




}
