package com.sevencows.business.dto;

public record TokenDto(
        String type,
        String token
) {
    public TokenDto(String token) {
        this("Bearer", token);
    }
}
