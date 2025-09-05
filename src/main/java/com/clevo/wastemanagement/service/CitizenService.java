package com.clevo.wastemanagement.service;
import com.clevo.wastemanagement.dto.BookingRequest;
import com.clevo.wastemanagement.dto.RewardRedeemRequest;
import com.clevo.wastemanagement.model.IBooking;
import com.clevo.wastemanagement.model.PickupSlot;
import com.clevo.wastemanagement.model.Reward;
import com.clevo.wastemanagement.repository.IBookingRepository;
import com.clevo.wastemanagement.repository.IPickupSlotRepository;
import com.clevo.wastemanagement.repository.RewardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenService {
    private final IPickupSlotRepository slotRepo;
    private final IBookingRepository bookingRepo;
    private final RewardRepository rewardRepo;

    public CitizenService(IPickupSlotRepository slotRepo, IBookingRepository bookingRepo, RewardRepository rewardRepo) {
        this.slotRepo = slotRepo;
        this.bookingRepo = bookingRepo;
        this.rewardRepo = rewardRepo;
    }

    // View available slots
    public List<PickupSlot> getAvailableSlots() {
        return slotRepo.findAll();
    }

    // Book a slot
    public IBooking bookSlot(BookingRequest request) {
        PickupSlot slot = slotRepo.findById(request.getSlotId())
                .orElseThrow(() -> new RuntimeException("Slot not found"));
        IBooking booking = new IBooking();
        booking.setSlot(slot);
        booking.setWasteCategory(request.getWasteCategory());
        booking.setEstimatedQuantity(request.getEstimatedQuantity());
        booking.setStatus("PENDING");
        return bookingRepo.save(booking);
    }

    // View all bookings
    public List<IBooking> getBookings() {
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
}
