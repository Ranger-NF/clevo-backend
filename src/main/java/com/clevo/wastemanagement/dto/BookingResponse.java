package com.clevo.wastemanagement.dto;

import com.clevo.wastemanagement.model.Booking;
import com.clevo.wastemanagement.model.WasteCategory;

import java.util.UUID;


public class BookingResponse {
        private UUID id;
        private WasteCategory wasteCategory;
        private Double quantity;
        private Booking.Status status;
        private String citizenUsername;

        // Default constructor
        public BookingResponse() {}

        // All-args constructor
        public BookingResponse(UUID id, WasteCategory wasteCategory, Double quantity, Booking.Status status, String citizenUsername) {
            this.id = id;
            this.wasteCategory = wasteCategory;
            this.quantity = quantity;
            this.status = status;
            this.citizenUsername = citizenUsername;
        }

        // Getters and Setters
        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public WasteCategory getCategory() {
            return wasteCategory;
        }

        public void setCategory(WasteCategory wasteCategory) {
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
        
        
    }
