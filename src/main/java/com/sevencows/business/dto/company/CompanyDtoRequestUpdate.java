package com.sevencows.business.dto.company;

import com.sevencows.business.model.enums.CompanyType;
import com.sevencows.business.model.enums.validation.ValidEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CompanyDtoRequestUpdate(

        @Schema(description = "Id", example = "12345")
        @NotNull(message = "Id is required")
        Long id,

        @Schema(description = "Trade name", example = "Company name")
        @NotBlank(message = "Trade name is required")
        @Size(min = 1, max = 60, message = "Trade name must be between 1 and 60 characters")
        String tradeName,

        @Schema(description = "Legal name", example = "Company name, SA")
        @NotBlank(message = "Legal name is required")
        @Size(min = 1, max = 60, message = "Legal name must be between 1 and 60 characters")
        String legalName,

        @Schema(description = "Company type", example = "FREE, MICRO, SMALL, MEDIUM or LARGE")
        @NotBlank(message = "Company type is required")
        @ValidEnum(enumClass = CompanyType.class, message = "FREE, MICRO, SMALL, MEDIUM or LARGE")
        String companyType,

        @Schema(description = "Incorporation date", example = "2025-09-10")
        @NotNull(message = "Incorporation date is required")
        LocalDate incorporationDate,

        @Schema(description = "System company modify time", example = "2025-09-10T15:01:16")
        @NotNull(message = "Modify date time is required")
        LocalDateTime modifyDateTime

) {
}
