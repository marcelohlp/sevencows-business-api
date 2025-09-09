package com.sevencows.business.validation.user.register;

import com.sevencows.business.exception.ActionNotAllowedException;
import com.sevencows.business.model.User;
import com.sevencows.business.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateUserEmail implements ValidateUserRegister{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void valid(User user) {
        String email = user.getEmail();
        if (userRepository.existsByEmail(email)) {
            throw new ActionNotAllowedException("Username already exists: " + email);
        }
    }

}
