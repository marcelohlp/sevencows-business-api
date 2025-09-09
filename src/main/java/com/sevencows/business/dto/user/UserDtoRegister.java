package com.sevencows.business.dto.user;

import com.sevencows.business.model.enums.Gender;
import com.sevencows.business.model.enums.Pronoun;
import com.sevencows.business.model.enums.validation.ValidEnum;
import com.sevencows.business.util.RegexConstant;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserDtoRegister(

        @NotBlank(message = "First name is required")
        @Size(min = 1, max = 30, message = "First name must be between 1 and 30 characters")
        String firstName,

        @NotBlank(message = "Last name is required")
        @Size(min = 1, max = 30, message = "First name must be between 1 and 30 characters")
        String lastName,

        @NotBlank(message = "Preferred name is required")
        @Size(min = 1, max = 30, message = "Preferred name must be between 1 and 30 characters")
        String preferredName,

        @NotBlank(message = "Email is required")
        @Size(min = 1, max = 120, message = "Email must be between 1 and 120 characters")
        @Email(message = "Invalid email format")
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
        @Pattern(regexp = RegexConstant.PASSWORD_REGEX, message = "Password must contain upper and lower case letters, numbers, and special characters")
        String password,

        @NotNull(message = "Birthday is required")
        LocalDate birthday,

        @NotNull(message = "Entry date time is required")
        LocalDateTime entryDateTime,

        @NotBlank(message = "User timezone is required")
        @Size(min = 1, max = 60, message = "User timezone must be between 1 and 60 characters")
        String userTimezone,

        @NotBlank(message = "Gender is required")
        @ValidEnum(enumClass = Gender.class, message = "Gender must be MALE, FEMALE, or OTHER")
        String gender,

        @NotBlank(message = "Pronoun is required")
        @ValidEnum(enumClass = Pronoun.class, message = "Pronoun must be HE or SHE")
        String pronoun

) {
}