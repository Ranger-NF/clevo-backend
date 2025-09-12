package com.clevo.wastemanagement.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.UUID;

@Data
@Entity
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
    @JsonIgnore   // 👈 hides password from JSON response
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    @Column(nullable = false)
    private boolean active = true;

    @Column(nullable = false, updatable = false)
    private java.time.Instant createdAt;

    @Column(nullable = false)
    private java.time.Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = updatedAt = java.time.Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = java.time.Instant.now();
    }

    public enum Role {
        CITIZEN, RECYCLER, AUTHORITY
    }

    public void setActive(boolean active) { this.active = active; }
    public boolean isActive() { return active; }

    public String getPassword() {
        return password;
    }

    public String getUsername() { return username; }
    public User.Role getRole() { return role; }
}
