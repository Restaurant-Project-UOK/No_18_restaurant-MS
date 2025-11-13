package com.example.auth_service.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.auth_service.Entity.PasswordReset;

@Repository
public interface PasswordResetRepository extends JpaRepository<PasswordReset, Integer> {

  Optional<PasswordReset> findByResetToken(String resetToken);

}