package com.sevencows.business.service;

import com.sevencows.business.exception.UnauthorizedActionException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceConfig implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return userService.findUserByEmail(username);
        } catch (UsernameNotFoundException e) {
            throw new UnauthorizedActionException("User not found!");
        }
    }

}
