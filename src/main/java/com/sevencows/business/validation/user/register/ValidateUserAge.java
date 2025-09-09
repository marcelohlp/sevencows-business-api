package com.sevencows.business.validation.user.register;

import com.sevencows.business.exception.ActionNotAllowedException;
import com.sevencows.business.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class ValidateUserAge implements ValidateUserRegister{

    @Override
    public void valid(User user) {

        LocalDate birthday = user.getBirthday();
        LocalDate today = LocalDate.now();
        Period period = Period.between(birthday, today);
        int age = period.getYears();

        if (age < 16) {
            throw new ActionNotAllowedException("User must be at least 16 years old");
        }
    }

}
