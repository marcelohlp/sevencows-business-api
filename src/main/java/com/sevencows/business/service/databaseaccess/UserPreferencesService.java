package com.sevencows.business.service.databaseaccess;

import com.sevencows.business.dto.user.UserDtoRegister;
import com.sevencows.business.model.User;
import com.sevencows.business.model.UserPreferences;
import com.sevencows.business.repository.UserPreferencesRepository;
import com.sevencows.business.validation.userpreferences.register.ValidateUserPreferencesRegister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPreferencesService {

    private final UserPreferencesRepository userPreferencesRepository;
    private final List<ValidateUserPreferencesRegister> validateUserPreferencesRegisterList;

    public UserPreferencesService(UserPreferencesRepository userPreferencesRepository,
                                  List<ValidateUserPreferencesRegister> validateUserPreferencesRegisterList) {
        this.userPreferencesRepository = userPreferencesRepository;
        this.validateUserPreferencesRegisterList = validateUserPreferencesRegisterList;
    }

    public UserPreferences addUserPreferences(User user, UserDtoRegister userDtoRegister) {
        UserPreferences userPreferences = new UserPreferences(user, userDtoRegister);
        validateUserPreferencesRegisterList.forEach(validator -> validator.valid(userPreferences));
        return userPreferencesRepository.save(userPreferences);
    }

}
