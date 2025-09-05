package com.clevo.wastemanagement.model;

import jakarta.persistence.*;
import lombok.Data;
public class IBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PickupSlot slot;

    private String wasteCategory;
    private Double estimatedQuantity;
    private String status;
}
