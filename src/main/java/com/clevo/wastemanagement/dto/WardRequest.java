package com.clevo.wastemanagement.dto;

import lombok.Data;

@Data
public class WardRequest {
    private String name;
    private String description;

    public String getName() { return name; }
    public String getDescription() { return description; }
}