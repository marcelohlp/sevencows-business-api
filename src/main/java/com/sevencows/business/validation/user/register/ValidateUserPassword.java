package com.sevencows.business.validation.user.register;

import com.sevencows.business.exception.ActionNotAllowedException;
import com.sevencows.business.model.User;
import com.sevencows.business.util.RegexConstant;
import org.springframework.stereotype.Component;

@Component
public class ValidateUserPassword implements ValidateUserRegister{

    @Override
    public void valid(User user) {
        String password = user.getPassword();
        if (!password.matches(RegexConstant.PASSWORD_REGEX)) {
            throw new ActionNotAllowedException("Password does not meet the required pattern");
        }
    }

}
