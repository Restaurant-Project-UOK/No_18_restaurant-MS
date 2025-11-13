package com.example.auth_service.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.auth_service.DTO.ResetPasswordRequestDto;
import com.example.auth_service.Service.PasswordService;

@RestController
@RequestMapping("/api/password")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    // Request password reset (send email)
    @PostMapping("/forgot")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        passwordService.createPasswordResetToken(email);
        return ResponseEntity.ok("Password reset email sent if user exists.");
    }

    // Reset password
    @PostMapping("/reset")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequestDto dto) {
        passwordService.resetPassword(dto.getResetToken(), dto.getNewPassword());
        return ResponseEntity.ok("Password reset successful.");
    }
}
