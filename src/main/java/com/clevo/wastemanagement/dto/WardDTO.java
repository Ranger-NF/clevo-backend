package com.clevo.wastemanagement.dto;

import java.util.UUID;

public class WardDTO {
    private UUID id;
    private String name;
    private String description;

    // ✅ no authority details for now (you can extend later if needed)

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
