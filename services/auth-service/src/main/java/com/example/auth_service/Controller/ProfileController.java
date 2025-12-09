package com.example.auth_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth_service.DTO.ProfileDto;
import com.example.auth_service.Entity.User;
import com.example.auth_service.Service.ProfileService;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    // Get profile of currentl
    @GetMapping("/me")
    public ResponseEntity<ProfileDto> getMyProfile(Authentication authentication) {
        User user = (User) authentication.getPrincipal(); // now contains full user
            Integer userId = user.getId();
        System.out.println("userId: +++++++++++++++" + userId);
        ProfileDto profileDto = profileService.getProfile(userId);
        return ResponseEntity.ok(profileDto);
    }

    // Update profile of currently logged-in user
    @PutMapping("/me")
    public ResponseEntity<ProfileDto> updateProfile(
            Authentication authentication,
            @RequestBody ProfileDto profileDto
    ) {
        Integer userId = (Integer) authentication.getPrincipal();
        System.out.println("userId: +++++++++++++++" + userId);
        ProfileDto updatedProfile = profileService.updateProfile(userId, profileDto);
        return ResponseEntity.ok(updatedProfile);
    }
}
