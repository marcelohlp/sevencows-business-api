package com.sevencows.business.advice;

import com.sevencows.business.dto.ExceptionDtoResponse;
import com.sevencows.business.exception.ActionNotAllowedException;
import com.sevencows.business.exception.DataNotFoundException;
import com.sevencows.business.exception.TokenException;
import com.sevencows.business.exception.UnauthorizedActionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ActionNotAllowedException.class)
    public ResponseEntity<ExceptionDtoResponse> getActionNotAllowedException(ActionNotAllowedException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ExceptionDtoResponse dto = new ExceptionDtoResponse(
                e.getMessage(),
                status,
                status.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(status).body(dto);
    }

    @ExceptionHandler(UnauthorizedActionException.class)
    public ResponseEntity<ExceptionDtoResponse> getUnauthorizedActionException(UnauthorizedActionException e) {
        HttpStatus status = HttpStatus.FORBIDDEN;
        ExceptionDtoResponse dto = new ExceptionDtoResponse(
                e.getMessage(),
                status,
                status.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(status).body(dto);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ExceptionDtoResponse> getDataNotFoundException(DataNotFoundException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionDtoResponse dto = new ExceptionDtoResponse(
                e.getMessage(),
                status,
                status.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(status).body(dto);
    }

    @ExceptionHandler(TokenException.class)
    public ResponseEntity<ExceptionDtoResponse> getTokenException(TokenException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ExceptionDtoResponse dto = new ExceptionDtoResponse(
                e.getMessage(),
                status,
                status.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(status).body(dto);
    }

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
