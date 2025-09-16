package com.sevencows.business.controller;

import com.sevencows.business.dto.company.CompanyDtoRequest;
import com.sevencows.business.dto.company.CompanyDtoResponse;
import com.sevencows.business.service.CompanyService;
import com.sevencows.business.service.NewCompanyTransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Company", description = "Company configuration end-points")
@RestController
@RequestMapping("api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;
    private final NewCompanyTransactionService newCompanyTransactionService;

    public CompanyController(
            CompanyService companyService,
            NewCompanyTransactionService newCompanyTransactionService
    ) {
        this.companyService = companyService;
        this.newCompanyTransactionService = newCompanyTransactionService;
    }

    @Operation(summary = "Register new company")
    @ApiResponse(responseCode = "201", description = "Company created")
    @ApiResponse(responseCode = "404", description = "User not found")
    @PostMapping()
    public ResponseEntity<CompanyDtoResponse> addCompany(@RequestBody @Valid CompanyDtoRequest companyDtoRequest) {
        CompanyDtoResponse companyDtoResponse = newCompanyTransactionService.addCompany(companyDtoRequest);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(companyDtoResponse);
    }

}
