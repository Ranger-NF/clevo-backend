package com.clevo.wastemanagement.repository;
import com.clevo.wastemanagement.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RewardRepository extends JpaRepository<Reward, Long> {
}