package com.example.auth_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {
    private String email;
    private String password; // optional if OAuth
    private Integer role;    // 1=CUSTOMER, 2=ADMIN, 3=KITCHEN
    private Integer provider; // 1=LOCAL, 2=GOOGLE
    private String fullName;
    private String phone;
    private String address;
}