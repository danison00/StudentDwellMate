package com.dan.StudentDwellMate.infra.tokenJWT;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dan.StudentDwellMate.model.entities.User;

@Component
public class TokenServiceImpl implements TokenService{

    // @Value("$(secrety.key.jwt)")
    private String secrety = "my-secrety-key";

    Algorithm algorithm = Algorithm.HMAC256(secrety);

    @Override
    public String generateJWT(User user) {

        try {

            return JWT.create()
                    .withIssuer("studentDwellMate")
                    .withSubject(user.getUsername())
                    .withExpiresAt(getInstant())
                    .sign(algorithm);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<String> decodeTokenJWT(String token) {

        try {

            return Optional.of(JWT.require(algorithm)
                    .withIssuer("studentDwellMate").build()
                    .verify(token).getSubject());

        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private Instant getInstant() {

        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
