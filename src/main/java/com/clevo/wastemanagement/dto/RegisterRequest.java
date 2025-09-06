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
}
