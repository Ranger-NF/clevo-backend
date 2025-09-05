package com.clevo.wastemanagement.controller;
import com.clevo.wastemanagement.dto.BookingRequest;
import com.clevo.wastemanagement.dto.RewardRedeemRequest;
import com.clevo.wastemanagement.model.Booking;
import com.clevo.wastemanagement.model.PickupSlot;
import com.clevo.wastemanagement.model.Reward;
import com.clevo.wastemanagement.service.CitizenService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/citizen")

public class CitizenController {
    private final CitizenService citizenService;

    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    // GET /api/citizen/slots
    @GetMapping("/slots")
    public List<PickupSlot> getSlots() {
        return citizenService.getAvailableSlots();
    }

    // POST /api/citizen/book
    @PostMapping("/book")
    public Booking bookSlot(@RequestBody BookingRequest request) {
        return citizenService.bookSlot(request);
    }

    // GET /api/citizen/bookings
    @GetMapping("/bookings")
    public List<Booking> getBookings() {
        return citizenService.getBookings();
    }

    // GET /api/citizen/rewards/total
    @GetMapping("/rewards/total")
    public int getTotalRewards() {
        return citizenService.getTotalRewards();
    }

    // GET /api/citizen/rewards/available
    @GetMapping("/rewards/available")
    public List<Reward> getAvailableRewards() {
        return citizenService.getAvailableRewards();
    }

    // POST /api/citizen/rewards/redeem
    @PostMapping("/rewards/redeem")
    public String redeemReward(@RequestBody RewardRedeemRequest request) {
        return citizenService.redeemReward(request);
    }
}
