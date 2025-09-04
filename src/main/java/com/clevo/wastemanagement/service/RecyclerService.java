package com.clevo.wastemanagement.service;

import com.clevo.wastemanagement.model.*;
import com.clevo.wastemanagement.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecyclerService {

    private final PickupSlotRepository pickupSlotRepository;
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;

    public RecyclerService(PickupSlotRepository pickupSlotRepository,
                           BookingRepository bookingRepository,
                           UserRepository userRepository) {
        this.pickupSlotRepository = pickupSlotRepository;
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
    }

    // Get recycler’s slots
    public List<PickupSlot> getRecyclerSlots(UUID recyclerId) {
        User recycler = userRepository.findById(recyclerId)
                .orElseThrow(() -> new RuntimeException("Recycler not found"));
        return pickupSlotRepository.findByRecycler(recycler);
    }

    // Create slot
    public PickupSlot createSlot(PickupSlot slot) {
        return pickupSlotRepository.save(slot);
    }

    // Update slot
    public PickupSlot updateSlot(UUID slotId, PickupSlot updated) {
        PickupSlot slot = pickupSlotRepository.findById(slotId)
                .orElseThrow(() -> new RuntimeException("Slot not found"));
        slot.setStartTime(updated.getStartTime());
        slot.setEndTime(updated.getEndTime());
        slot.setCapacity(updated.getCapacity());
        slot.setIsActive(updated.getIsActive());
        return pickupSlotRepository.save(slot);
    }

    // Delete slot
    public void deleteSlot(UUID slotId) {
        pickupSlotRepository.deleteById(slotId);
    }

    // Get bookings for a ward
    public List<Booking> getBookingsByWard(UUID wardId) {
        return bookingRepository.findByPickupSlot_Ward_Id(wardId);
    }

    // Update booking status
    public Booking updateBookingStatus(UUID bookingId, String status, Double actualQuantity) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus(Booking.Status.valueOf(status.toUpperCase()));
        if (Booking.Status.COLLECTED.name().equals(status.toUpperCase())) {
            booking.setActualQuantity(actualQuantity);
        }
        return bookingRepository.save(booking);
    }
}
