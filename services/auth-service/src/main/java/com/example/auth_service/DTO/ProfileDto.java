package com.example.auth_service.DTO;

import java.time.LocalDateTime;

import com.example.auth_service.Entity.Profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {

    private Integer id;           // same as user.id
    private String email;         // from user entity
    private String fullName;
    private String phone;
    private String address;
    private String additionalInfo; // JSON as string
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /** Mapping method from Profile entity */
    public static ProfileDto fromEntity(Profile profile) {
        return new ProfileDto(
            profile.getUser().getId(),
            profile.getUser().getEmail(),
            profile.getFullName(),
            profile.getPhone(),
            profile.getAddress(),
            profile.getAdditionalInfo(),
            profile.getCreatedAt(),
            profile.getUpdatedAt()
        );
    }
}
