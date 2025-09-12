package com.sevencows.business.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record TokenDto(

        @Schema(description = "Token type", example = "Bearer")
        String type,

        @Schema(description = "Token code", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3M...")
        String token
) {
    public TokenDto(String token) {
        this("Bearer", token);
    }
}
