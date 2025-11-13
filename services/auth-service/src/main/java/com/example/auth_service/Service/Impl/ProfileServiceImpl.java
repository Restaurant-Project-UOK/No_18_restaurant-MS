package com.example.auth_service.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.auth_service.DTO.ProfileDto;
import com.example.auth_service.DTO.UserResponseDto;
import com.example.auth_service.Entity.Profile;
import com.example.auth_service.Entity.User;
import com.example.auth_service.Repository.ProfileRepository;
import com.example.auth_service.Repository.UserRepository;
import com.example.auth_service.Service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public UserResponseDto getProfile(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserResponseDto(user);
    }

    @Transactional
    @Override
    public UserResponseDto updateProfile(Integer userId, ProfileDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Profile profile = user.getProfile();
        if (profile == null) {
            profile = new Profile();
            profile.setUser(user);
        }

        profile.setFullName(dto.getFullName());
        profile.setPhone(dto.getPhone());
        profile.setAddress(dto.getAddress());
        profile.setAdditionalInfo(dto.getAdditionalInfo());

        profileRepository.save(profile);

        return new UserResponseDto(user);
    }
}
