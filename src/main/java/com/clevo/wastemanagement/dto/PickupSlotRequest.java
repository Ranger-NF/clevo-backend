package com.clevo.wastemanagement.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class PickupSlotRequest {
    private UUID recyclerId;
    private UUID wardId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer capacity;
    private Boolean isActive;

    public UUID getRecyclerId() { return recyclerId; }
    public void setRecyclerId(UUID recyclerId) { this.recyclerId = recyclerId; }

    public UUID getWardId() { return wardId; }
    public void setWardId(UUID wardId) { this.wardId = wardId; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
}

