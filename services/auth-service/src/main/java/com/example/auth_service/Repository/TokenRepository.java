package com.example.auth_service.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.auth_service.Entity.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

    Optional<Token> findByToken(String token);

}