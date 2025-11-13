package com.example.auth_service.Service.Impl;


import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.auth_service.Entity.PasswordReset;
import com.example.auth_service.Entity.User;
import com.example.auth_service.Repository.PasswordResetRepository;
import com.example.auth_service.Repository.UserRepository;
import com.example.auth_service.Service.PasswordService;



@Service
public class PasswordServiceImpl implements PasswordService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetRepository resetRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void createPasswordResetToken(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = UUID.randomUUID().toString();

        PasswordReset reset = PasswordReset.builder()
                .user(user)
                .resetToken(token)
                .expiry(LocalDateTime.now().plusMinutes(30)) // 30 min expiry
                .build();

        resetRepository.save(reset);

        // TODO: send token to user's email
        System.out.println("Password reset token for " + email + ": " + token);
    }

    @Transactional
    @Override
    public void sendResetEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = UUID.randomUUID().toString();
        PasswordReset reset = new PasswordReset();
        reset.setUser(user);
        reset.setResetToken(token);
        reset.setExpiry(LocalDateTime.now().plusMinutes(15));

        resetRepository.save(reset);

        // send email with reset link
        // e.g., https://frontend.com/reset-password?token=token
    }

    @Transactional
    @Override
    public void resetPassword(String resetToken, String newPassword) {
        PasswordReset reset = resetRepository.findByResetToken(resetToken)
                .orElseThrow(() -> new RuntimeException("Invalid reset token"));

        if (reset.getExpiry().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Reset token expired");
        }

        User user = reset.getUser();
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);

        resetRepository.delete(reset); // invalidate token
    }
}