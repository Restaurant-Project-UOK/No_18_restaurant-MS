package com.example.auth_service.DTO;

import com.example.auth_service.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponseDto {
    
    public TokenResponseDto(String newAccessToken, String newRefreshToken, int i, int j, User user) {
        //TODO Auto-generated constructor stub
    }
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpiry; // epoch millis
    private Long refreshTokenExpiry; // epoch millis

    
}

