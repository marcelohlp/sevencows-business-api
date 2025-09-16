package com.sevencows.business.dto.company;

import com.sevencows.business.model.Company;
import com.sevencows.business.model.enums.CompanyType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CompanyDtoResponse(

        @Schema(description = "Id", example = "12034")
        Long id,

        @Schema(description = "Trade name", example = "Company name")
        String tradeName,

        @Schema(description = "Legal name", example = "Company name, SA")
        String legalName,

        @Schema(description = "Company type", example = "FREE, MICRO, SMALL, MEDIUM or LARGE")
        CompanyType companyType,

        @Schema(description = "Incorporation date", example = "2025-09-10")
        LocalDate incorporationDate,

        @Schema(description = "System company entry time", example = "2025-09-10T15:01:16")
        LocalDateTime entryDateTime,

        @Schema(description = "System company modify time", example = "2025-09-10T15:01:16")
        LocalDateTime modifyDateTime

) {

    public CompanyDtoResponse(Company company) {
        this(
                company.getId(),
                company.getTradeName(),
                company.getLegalName(),
                company.getCompanyType(),
                company.getIncorporationDate(),
                company.getEntryDateTime(),
                company.getModifyDateTime()
        );
    }

}
