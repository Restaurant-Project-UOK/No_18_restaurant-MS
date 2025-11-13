package com.example.auth_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResetPasswordRequestDto {
    private String resetToken;
    private String newPassword;
}