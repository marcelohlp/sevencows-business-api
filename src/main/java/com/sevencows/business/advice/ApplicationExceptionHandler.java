package com.sevencows.business.advice;

import com.sevencows.business.dto.ExceptionDtoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDtoResponse> getException(Exception e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ExceptionDtoResponse dto = new ExceptionDtoResponse(
                e.getMessage(),
                status,
                status.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(status).body(dto);
    }

}
