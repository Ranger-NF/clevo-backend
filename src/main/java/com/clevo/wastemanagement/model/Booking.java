package com.clevo.wastemanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
