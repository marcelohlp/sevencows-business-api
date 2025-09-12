package com.sevencows.business.dto.user;

import com.sevencows.business.model.enums.Gender;
import com.sevencows.business.model.enums.Pronoun;
import com.sevencows.business.model.enums.validation.ValidEnum;
import com.sevencows.business.util.RegexConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import org.aspectj.bridge.IMessage;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserDtoRegister(

        @Schema(description = "User first name", example = "John")
        @NotBlank(message = "First name is required")
        @Size(min = 1, max = 30, message = "First name must be between 1 and 30 characters")
        String firstName,

        @Schema(description = "User last name", example = "Smith")
        @NotBlank(message = "Last name is required")
        @Size(min = 1, max = 30, message = "First name must be between 1 and 30 characters")
        String lastName,

        @Schema(description = "User preferred name", example = "Smith")
        @NotBlank(message = "Preferred name is required")
        @Size(min = 1, max = 30, message = "Preferred name must be between 1 and 30 characters")
        String preferredName,

        @Schema(description = "User email", example = "example@mail.com")
        @NotBlank(message = "Email is required")
        @Size(min = 1, max = 120, message = "Email must be between 1 and 120 characters")
        @Email(message = "Invalid email format")
        String email,

        @Schema(description = "User password", example = "123Qwert&")
        @NotBlank(message = "Password is required")
        @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
        @Pattern(regexp = RegexConstant.PASSWORD_REGEX, message = "Password must contain upper and lower case letters, numbers, and special characters")
        String password,

        @Schema(description = "User birthday", example = "1990-10-15")
        @NotNull(message = "Birthday is required")
        LocalDate birthday,

        @Schema(description = "System user entry time", example = "2025-09-10T15:01:16")
        @NotNull(message = "Entry date time is required")
        LocalDateTime entryDateTime,

        @Schema(description = "User timezone", example = "America/Sao_Paulo")
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