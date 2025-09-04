package com.sevencows.business.config.security;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Bean
    public Algorithm jwtAlgorithm(@Value("${secret.word}") String secretWord) {
        return Algorithm.HMAC256(secretWord);
    }

}
