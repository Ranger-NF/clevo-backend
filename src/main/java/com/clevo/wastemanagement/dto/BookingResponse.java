package com.clevo.wastemanagement.dto;

import com.clevo.wastemanagement.model.Booking;
import com.clevo.wastemanagement.model.WasteCategory;

import java.time.LocalDateTime;
import java.util.UUID;


public class BookingResponse {
        private UUID id;
        private WasteCategory wasteCategory;
        private Double quantity;
        private Booking.Status status;
        private String citizenUsername;
        private LocalDateTime createdAt;

        // Default constructor
        public BookingResponse() {}

        // All-args constructor
        public BookingResponse(UUID id, WasteCategory wasteCategory, Double quantity, Booking.Status status, String citizenUsername, LocalDateTime createdAt) {
            this.id = id;
            this.wasteCategory = wasteCategory;
            this.quantity = quantity;
            this.status = status;
            this.citizenUsername = citizenUsername;
            this.createdAt = createdAt;
        }

        // Getters and Setters
        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public WasteCategory getWasteCategory() {
            return wasteCategory;
        }

        public void setWasteCategory(WasteCategory wasteCategory) {
            this.wasteCategory = wasteCategory  ;
        }

        public Double getQuantity() {
            return quantity;
        }

        public void setQuantity(Double quantity) {
            this.quantity = quantity;
        }

        public Booking.Status getStatus() {
            return status;
        }

        public void setStatus(Booking.Status status) {
            this.status = status;
        }

        public String getCitizenUsername() {
            return citizenUsername;
        }

        public void setCitizenUsername(String citizenUsername) {
            this.citizenUsername = citizenUsername;
        }
        
        public LocalDateTime getCreatedAt() {return this.createdAt;}

        public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}
    }
