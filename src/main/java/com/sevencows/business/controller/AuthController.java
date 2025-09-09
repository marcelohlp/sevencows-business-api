package com.sevencows.business.controller;

import com.sevencows.business.dto.TokenDto;
import com.sevencows.business.dto.user.UserDtoLogin;
import com.sevencows.business.dto.user.UserDtoRegister;
import com.sevencows.business.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<TokenDto> register(@RequestBody @Valid UserDtoRegister userDtoRegister) {
        TokenDto tokenDto = authService.register(userDtoRegister);
        return ResponseEntity.status(HttpStatus.CREATED).body(tokenDto);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody @Valid UserDtoLogin userDtoLogin) {
        TokenDto tokenDto = authService.login(userDtoLogin);
        return ResponseEntity.status(HttpStatus.OK).body(tokenDto);
    }

}
