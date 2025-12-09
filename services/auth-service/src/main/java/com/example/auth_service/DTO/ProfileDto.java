package com.example.auth_service.DTO;

import java.time.LocalDateTime;

import com.example.auth_service.Entity.Profile;
import com.example.auth_service.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {

    // User fields
    private Integer id;
    private String email;
    private Integer role;      // 1=CUSTOMER, 2=ADMIN, 3=KITCHEN
    private Integer provider;  // 1=LOCAL, 2=GOOGLE

    // Profile fields
    private String fullName;
    private String phone;
    private String address;
    private String additionalInfo;

    // Constructor to combine User + Profile
    public ProfileDto(User user, Profile profile) {
        this.fullName = profile.getFullName();
        this.phone = profile.getPhone();
        this.address = profile.getAddress();
        this.additionalInfo = profile.getAdditionalInfo();

        this.fullName = profile.getFullName();
        this.phone = profile.getPhone();
        this.address = profile.getAddress();
        this.additionalInfo = profile.getAdditionalInfo();
    }
}
