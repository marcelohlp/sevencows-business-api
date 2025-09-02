package com.sevencows.business.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ExceptionDtoResponse(
        String message,
        HttpStatus httpStatus,
        Integer httpCode,
        LocalDateTime now
) {
}
