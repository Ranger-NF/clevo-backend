package com.clevo.wastemanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    @Column(nullable = false)
    private boolean active = true;

    public enum Role {
        CITIZEN, RECYCLER, AUTHORITY
    }

    public void setActive(boolean active) { this.active = active; }
    public boolean isActive() { return active; }
}
