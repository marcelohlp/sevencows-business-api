package com.sevencows.business.service;

import com.sevencows.business.dto.user.UserDtoRegister;
import com.sevencows.business.model.User;
import com.sevencows.business.repository.UserRepository;
import com.sevencows.business.util.OptionalContentExtractor;
import com.sevencows.business.validation.user.register.ValidateUserRegister;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final List<ValidateUserRegister> validateUserRegisterList;
    private final OptionalContentExtractor optionalContentExtractor;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       List<ValidateUserRegister> validateUserRegisterList,
                       OptionalContentExtractor optionalContentExtractor) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.validateUserRegisterList = validateUserRegisterList;
        this.optionalContentExtractor = optionalContentExtractor;
    }

    protected User addUser(UserDtoRegister userDtoRegister) {
        User user;
        String encryptedPassword = passwordEncoder.encode(userDtoRegister.password());
        user = new User(userDtoRegister);
        validateUserRegisterList.forEach(validator -> validator.valid(user));
        user.setEncryptedPassword(encryptedPassword);
        return userRepository.save(user);
    }

    protected UserDetails findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findById(Long id) {
        Optional<User> optional = userRepository.findById(id);
        String errorMessage = "User not found by id: " + id;
        return optionalContentExtractor.getOrThrows(optional, errorMessage);
    }

}
