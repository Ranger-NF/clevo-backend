package com.clevo.wastemanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ward {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "authority_id")
    private User authority;



    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
}
