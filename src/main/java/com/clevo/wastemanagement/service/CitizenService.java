package com.clevo.wastemanagement.service;
import com.clevo.wastemanagement.dto.BookingRequest;
import com.clevo.wastemanagement.dto.RewardRedeemRequest;
import com.clevo.wastemanagement.model.*;
import com.clevo.wastemanagement.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenService {
    private final PickupSlotRepository slotRepo;
    private final BookingRepository bookingRepo;
    private final RewardRepository rewardRepo;
    private final WasteCategoryRepository wasteCategoryRepo;
    private final UserRepository userRepo;

    public CitizenService(PickupSlotRepository slotRepo, BookingRepository bookingRepo, RewardRepository rewardRepo, WasteCategoryRepository wasteCategoryRepo, UserRepository userRepository) {
        this.slotRepo = slotRepo;
        this.bookingRepo = bookingRepo;
        this.rewardRepo = rewardRepo;
        this.wasteCategoryRepo = wasteCategoryRepo;
        this.userRepo = userRepository;
    }

    // View available slots
    public List<PickupSlot> getAvailableSlots() {
        return slotRepo.findAll();
    }

    // Book a slot
    public Booking bookSlot(BookingRequest request, String username) {
        PickupSlot slot = slotRepo.findById(request.getSlotId())
                .orElseThrow(() -> new RuntimeException("Slot not found"));
        WasteCategory wasteCategory = wasteCategoryRepo.findById(request.getWasteCategoryId())
                .orElseThrow(() -> new RuntimeException("Waste category not found"));
        User citizen = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Booking booking = new Booking();
        booking.setCitizen(citizen);
        booking.setPickupSlot(slot);
        booking.setWasteCategory(wasteCategory);
        booking.setEstimatedQuantity(request.getEstimatedQuantity());
        booking.setStatus(Booking.Status.PENDING);
        // ...set citizen if needed...
        return bookingRepo.save(booking);
    }

    // View all bookings
    public List<Booking> getBookings() {
        return bookingRepo.findAll();
    }

    // Total rewards
    public int getTotalRewards() {
        return rewardRepo.findAll().stream().mapToInt(Reward::getPoints).sum();
    }

    // Available rewards
    public List<Reward> getAvailableRewards() {
        return rewardRepo.findAll();
    }

    // Redeem reward
    public String redeemReward(RewardRedeemRequest request) {
        Reward reward = rewardRepo.findById(request.getRewardId())
                .orElseThrow(() -> new RuntimeException("Reward not found"));
        rewardRepo.delete(reward);
        return "Reward Redeemed: " + reward.getName();
    }

    public List<WasteCategory> listWasteCategories() {
        return wasteCategoryRepo.findAll();
    }

}
