package com.sevencows.business.config.security;

import com.sevencows.business.exception.UnauthorizedActionException;
import com.sevencows.business.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticatedUser {

    private User getAuthenticatedUser() {
        Authentication authentication;
        authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            throw new UnauthorizedActionException("Unauthorized access");
        }

        Object object = authentication.getPrincipal();

        if (!(object instanceof  User)) {
            throw new UnauthorizedActionException("Unauthorized access");
        }

        return (User) object;
    }

    public Long getUserId() {
        return getAuthenticatedUser().getId();
    }

}
