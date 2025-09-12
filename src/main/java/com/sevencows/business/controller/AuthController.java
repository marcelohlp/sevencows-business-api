package com.sevencows.business.controller;

import com.sevencows.business.dto.ExceptionDtoResponse;
import com.sevencows.business.dto.TokenDto;
import com.sevencows.business.dto.user.UserDtoLogin;
import com.sevencows.business.dto.user.UserDtoRegister;
import com.sevencows.business.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authorization", description = "User authorization end-points")
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(summary = "Register new user")
    @ApiResponse(responseCode = "201", description = "User created")
    @ApiResponse(responseCode = "400", description = "Request wrong content")
    @PostMapping("/register")
    public ResponseEntity<TokenDto> register(@RequestBody @Valid UserDtoRegister userDtoRegister) {
        TokenDto tokenDto = authService.register(userDtoRegister);
        return ResponseEntity.status(HttpStatus.CREATED).body(tokenDto);
    }

    @Operation(summary = "User login")
    @ApiResponse(
            responseCode = "200",
            description = "User authorized",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = TokenDto.class))
    )
    @ApiResponse(
            responseCode = "400",
            description = "Request wrong content",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ExceptionDtoResponse.class))
    )
    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody @Valid UserDtoLogin userDtoLogin) {
        TokenDto tokenDto = authService.login(userDtoLogin);
        return ResponseEntity.status(HttpStatus.OK).body(tokenDto);
    }

}
