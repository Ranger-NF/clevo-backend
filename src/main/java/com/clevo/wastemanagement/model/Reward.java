package com.clevo.wastemanagement.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int points;
}
