package com.clevo.wastemanagement.dto;

import lombok.Data;

@Data
public class RewardRedeemRequest {
    private Long rewardId;

    public Long getRewardId() {
        return rewardId;
    }
}
