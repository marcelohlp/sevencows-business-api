package com.sevencows.business.dto;

public record TokenDto(
        String type,
        String token
) {
    public TokenDto(String token) {
        this(token, "Bearer");
    }
}
