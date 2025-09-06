package com.clevo.wastemanagement.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "citizen_id", nullable = false)
    private User citizen;

    @ManyToOne
    @JoinColumn(name = "pickup_slot_id", nullable = false)
    private PickupSlot pickupSlot;

    @ManyToOne
    @JoinColumn(name = "waste_category_id", nullable = false)
    private WasteCategory wasteCategory;

    private Double estimatedQuantity; // in kg
    private Double actualQuantity;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    private String confirmationCode;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public enum Status {
        PENDING, CONFIRMED, COLLECTED, CANCELLED
    }

    public void setStatus(Status status) { this.status = status; }
    public void setActualQuantity(Double actualQuantity) { this.actualQuantity = actualQuantity; }
    public void setPickupSlot(PickupSlot pickupSlot) { this.pickupSlot = pickupSlot; }
    public void setWasteCategory(WasteCategory wasteCategory) { this.wasteCategory = wasteCategory; }
    public void setEstimatedQuantity(Double estimatedQuantity) { this.estimatedQuantity = estimatedQuantity; }
}