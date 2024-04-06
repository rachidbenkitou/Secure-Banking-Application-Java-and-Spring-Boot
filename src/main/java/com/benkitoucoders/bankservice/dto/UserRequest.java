package com.benkitoucoders.bankservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
    private String stateOfOrigin;
    private String email;
    private String phoneNumber;
    private String address;
    private String alternativePhoneNumber;
    private String status;
}
