package com.dan.StudentDwellMate.infra.tokenJWT;

import java.util.Optional;

import com.dan.StudentDwellMate.model.entities.User;

/**
 * TokenService
 */
public interface TokenService {
    String generateJWT(User user);

    Optional<String> decodeTokenJWT(String token);

}