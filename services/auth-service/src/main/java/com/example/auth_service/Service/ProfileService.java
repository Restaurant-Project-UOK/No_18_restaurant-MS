package com.example.auth_service.Service;

import com.example.auth_service.DTO.ProfileDto;
import com.example.auth_service.DTO.UserResponseDto;

public interface ProfileService {
    UserResponseDto getProfile(Integer userId);
    UserResponseDto updateProfile(Integer userId, ProfileDto dto);
}