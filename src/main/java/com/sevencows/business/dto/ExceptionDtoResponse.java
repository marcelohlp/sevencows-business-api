package com.sevencows.business.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ExceptionDtoResponse(

        @Schema(description = "Exception message", example = "Validation failed")
        String message,

        @Schema(description = "Exception HTTP status", example = "INTERNAL_SERVER_ERROR")
        HttpStatus httpStatus,

        @Schema(description = "Exception HTTP code", example = "500")
        Integer httpCode,

        @Schema(description = "Exception occurred moment", example = "2025-09-10T15:01:16.7364732")
        LocalDateTime now
) {
}
