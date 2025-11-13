package com.example.auth_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.example.auth_service.DTO.ProfileDto;
import com.example.auth_service.DTO.UserResponseDto;
import com.example.auth_service.Service.ProfileService;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    // Get profile of currently logged-in user
    @GetMapping("/me")
    public ResponseEntity<UserResponseDto> getMyProfile(Authentication authentication) {
        Integer userId = (Integer) authentication.getPrincipal();
        return ResponseEntity.ok(profileService.getProfile(userId));
    }
}
