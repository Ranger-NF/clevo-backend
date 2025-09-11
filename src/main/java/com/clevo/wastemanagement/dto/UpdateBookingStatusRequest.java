package com.clevo.wastemanagement.dto;

import lombok.Data;

@Data
public class UpdateBookingStatusRequest {
    private String status;

    public String getStatus() {
        return status;
    }
}
