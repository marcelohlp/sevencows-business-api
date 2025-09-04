package com.sevencows.business.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.sevencows.business.exception.TokenException;
import com.sevencows.business.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private final Algorithm algorithm;
    private final Long tokenDuration;
    private final String issuer;

    public TokenService(@Qualifier("jwtAlgorithm") Algorithm algorithm,
                        @Value("${secret.expire.time}") Long tokenDuration,
                        @Value("${secret.issuer}") String issuer) {
        this.algorithm = algorithm;
        this.tokenDuration = tokenDuration;
        this.issuer = issuer;
    }

    public String getToken(User user) {
        try {
            return JWT.create()
                    .withIssuer(issuer)
                    .withSubject(user.getUsername())
                    .withClaim("userId", user.getId())
                    .withExpiresAt(getExpireTime())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new TokenException("Failed to create token");
        }
    }

    private Instant getExpireTime() {
        return LocalDateTime
                .now()
                .plusHours(tokenDuration)
                .toInstant(ZoneOffset.of("-03:00"));
    }

    public String validToken(String token) {
        try {
            return JWT
                    .require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return "";
        }
    }

}
