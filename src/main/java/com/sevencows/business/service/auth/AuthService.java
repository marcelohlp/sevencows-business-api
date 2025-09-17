package com.sevencows.business.service.auth;

import com.sevencows.business.config.security.TokenService;
import com.sevencows.business.dto.TokenDto;
import com.sevencows.business.dto.user.UserDtoLogin;
import com.sevencows.business.dto.user.UserDtoRegister;
import com.sevencows.business.model.User;
import com.sevencows.business.service.databaseaccess.UserPreferencesService;
import com.sevencows.business.service.databaseaccess.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private final UserService userService;
    private final UserPreferencesService userPreferencesService;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserService userService,
                       UserPreferencesService userPreferencesService,
                       TokenService tokenService,
                       AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.userPreferencesService = userPreferencesService;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @Transactional
    public TokenDto register(UserDtoRegister userDtoRegister) {
        User user = userService.addUser(userDtoRegister);
        userPreferencesService.addUserPreferences(user, userDtoRegister);
        String token = tokenService.getToken(user);
        return new TokenDto(token);
    }

    public TokenDto login(UserDtoLogin userDtoLogin) {
        String email = userDtoLogin.email();
        String password = userDtoLogin.password();
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(email, password);
        Authentication authentication = authenticationManager
                .authenticate(usernamePasswordAuthenticationToken);
        String token = tokenService.getToken((User) authentication.getPrincipal());
        return new TokenDto(token);
    }

}
