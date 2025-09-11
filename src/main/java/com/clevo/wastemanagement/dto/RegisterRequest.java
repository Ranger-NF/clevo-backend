package com.clevo.wastemanagement.dto;

import com.clevo.wastemanagement.model.User;
import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private User.Role role;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public com.clevo.wastemanagement.model.User.Role getRole() { return role; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
}
