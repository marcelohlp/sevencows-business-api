package com.sevencows.business.validation.userpreferences.register;

import com.sevencows.business.exception.ActionNotAllowedException;
import com.sevencows.business.model.UserPreferences;
import org.springframework.stereotype.Component;

import java.time.DateTimeException;
import java.time.ZoneId;

@Component
public class ValidateUserTimezone implements ValidateUserPreferencesRegister {

    @Override
    public void valid(UserPreferences userPreferences) {
        String userTimezone = userPreferences.getUserTimezone();
        try {
            ZoneId.of(userTimezone);
        } catch (DateTimeException e) {
            throw new ActionNotAllowedException("Invalid user timezone: " + userTimezone);
        }
    }

}
