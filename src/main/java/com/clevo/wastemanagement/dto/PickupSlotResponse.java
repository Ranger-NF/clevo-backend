package com.clevo.wastemanagement.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class PickupSlotResponse {
    private UUID id;
    private UserDTO recycler;
    private WardDTO ward;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer capacity;
    private Integer currentBookingsCount;
    private Boolean isActive;

    // getters and setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UserDTO getRecycler() { return recycler; }
    public void setRecycler(UserDTO recycler) { this.recycler = recycler; }

    public WardDTO getWard() { return ward; }
    public void setWard(WardDTO ward) { this.ward = ward; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public Integer getCurrentBookingsCount() { return currentBookingsCount; }
    public void setCurrentBookingsCount(Integer currentBookingsCount) { this.currentBookingsCount = currentBookingsCount; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
}
