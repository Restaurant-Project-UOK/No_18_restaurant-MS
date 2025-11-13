package com.example.auth_service.DTO;

import com.example.auth_service.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserResponseDto {
    public UserResponseDto(User user) {
    //TODO Auto-generated constructor stub
  }
    private Integer id;
    private String email;
    private Integer role;      // 1=CUSTOMER, 2=ADMIN, 3=KITCHEN
    private Integer provider;  // 1=LOCAL, 2=GOOGLE
    private ProfileDto profile;
}