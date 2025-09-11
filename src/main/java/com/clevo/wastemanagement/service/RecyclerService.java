package com.clevo.wastemanagement.service;

import com.clevo.wastemanagement.dto.PickupSlotRequest;
import com.clevo.wastemanagement.model.*;
import com.clevo.wastemanagement.repository.*;
import org.springframework.stereotype.Service;
import com.clevo.wastemanagement.dto.*;
import java.util.List;
import java.util.UUID;

@Service
public class RecyclerService {


    private PickupSlotResponse mapToDto(PickupSlot slot) {
        PickupSlotResponse dto = new PickupSlotResponse();
        dto.setId(slot.getId());
        dto.setStartTime(slot.getStartTime());
        dto.setEndTime(slot.getEndTime());
        dto.setCapacity(slot.getCapacity());
        dto.setCurrentBookingsCount(slot.getCurrentBookingsCount());
        dto.setIsActive(slot.getIsActive());

        // Map recycler (User → UserDTO)
        if (slot.getRecycler() != null) {
            UserDTO recyclerDto = new UserDTO();
            recyclerDto.setId(slot.getRecycler().getId());
            recyclerDto.setUsername(slot.getRecycler().getUsername());
            recyclerDto.setEmail(slot.getRecycler().getEmail());
            recyclerDto.setRole(slot.getRecycler().getRole().name());
            recyclerDto.setFirstName(slot.getRecycler().getFirstName());
            recyclerDto.setLastName(slot.getRecycler().getLastName());
            recyclerDto.setPhoneNumber(slot.getRecycler().getPhoneNumber());
            dto.setRecycler(recyclerDto);
        }

        // Map ward (Ward → WardDTO)
        if (slot.getWard() != null) {
            WardDTO wardDto = new WardDTO();
            wardDto.setId(slot.getWard().getId());
            wardDto.setName(slot.getWard().getName());
            wardDto.setDescription(slot.getWard().getDescription());
            dto.setWard(wardDto);
        }

        return dto;
    }

    private final PickupSlotRepository pickupSlotRepository;
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final WardRepository wardRepository; // ✅ Added

    public RecyclerService(PickupSlotRepository pickupSlotRepository,
                           BookingRepository bookingRepository,
                           UserRepository userRepository,
                           WardRepository wardRepository) {
        this.pickupSlotRepository = pickupSlotRepository;
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.wardRepository = wardRepository;
    }

    // Get recycler’s slots
    public List<PickupSlot> getRecyclerSlots(UUID recyclerId) {
        return pickupSlotRepository.findByRecycler_Id(recyclerId);
    }


    // ✅ Create slot using DTO
    public PickupSlot createSlot(PickupSlotRequest request) {
        User recycler = userRepository.findById(request.getRecyclerId())
                .orElseThrow(() -> new RuntimeException("Recycler not found"));
        Ward ward = wardRepository.findById(request.getWardId())
                .orElseThrow(() -> new RuntimeException("Ward not found"));

        PickupSlot slot = PickupSlot.builder()
                .recycler(recycler)
                .ward(ward)
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .capacity(request.getCapacity())
                .isActive(request.getIsActive())
                .currentBookingsCount(0)
                .build();

        return pickupSlotRepository.save(slot);
    }

    // ✅ Update slot using DTO
    public PickupSlot updateSlot(UUID slotId, PickupSlotRequest request) {
        PickupSlot slot = pickupSlotRepository.findById(slotId)
                .orElseThrow(() -> new RuntimeException("Slot not found"));

        slot.setStartTime(request.getStartTime());
        slot.setEndTime(request.getEndTime());
        slot.setCapacity(request.getCapacity());
        slot.setIsActive(request.getIsActive());

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
