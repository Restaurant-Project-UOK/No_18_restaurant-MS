package com.example.auth_service.Service;

public interface PasswordService {
    void createPasswordResetToken(String email);
    void sendResetEmail(String email);
    void resetPassword(String resetToken, String newPassword);
}