package com.example.auth_service.Service;


import com.example.auth_service.DTO.TokenResponseDto;

public interface TokenService {
    TokenResponseDto refreshToken(String refreshToken);
}