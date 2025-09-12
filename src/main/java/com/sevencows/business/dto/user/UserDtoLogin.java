package com.sevencows.business.dto.user;

import com.sevencows.business.util.RegexConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserDtoLogin(

        @Schema(description = "User email", example = "example@mail.com")
        @NotBlank(message = "Email is required")
        @Size(min = 1, max = 120, message = "Email must be between 1 and 120 characters")
        @Email(message = "Invalid email format")
        String email,

        @Schema(description = "User password", example = "123Qwert&")
        @NotBlank(message = "Password is required")
        @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
        @Pattern(regexp = RegexConstant.PASSWORD_REGEX, message = "Password must contain upper and lower case letters, numbers, and special characters")
        String password

) {
}
