package com.clevo.wastemanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
}
