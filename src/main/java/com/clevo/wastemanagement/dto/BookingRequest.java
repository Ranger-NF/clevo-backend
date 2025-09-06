package com.clevo.wastemanagement.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class BookingRequest {
    private UUID slotId;
    private UUID wasteCategoryId;
    private Double estimatedQuantity;

    public java.util.UUID getSlotId() { return slotId; }
    public java.util.UUID getWasteCategoryId() { return wasteCategoryId; }
    public Double getEstimatedQuantity() { return estimatedQuantity; }
}

