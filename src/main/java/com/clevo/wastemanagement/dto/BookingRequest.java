package com.clevo.wastemanagement.dto;
import lombok.Data;
@Data
public class BookingRequest {
    private Long slotId;
    private String wasteCategory;
    private Double estimatedQuantity;
}

