package com.sevencows.business.controller;

import com.sevencows.business.dto.ExceptionDtoResponse;
import com.sevencows.business.dto.company.CompanyDtoRequest;
import com.sevencows.business.dto.company.CompanyDtoRequestUpdate;
import com.sevencows.business.dto.company.CompanyDtoResponse;
import com.sevencows.business.facade.CompanyFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Company", description = "Company configuration end-points")
@RestController
@RequestMapping("api/v1/companies")
public class CompanyController {

    private final CompanyFacade companyFacade;

    public CompanyController(CompanyFacade companyFacade) {
        this.companyFacade = companyFacade;
    }

    @Operation(summary = "Get user company by id")
    @ApiResponse(
            responseCode = "200",
            description = "Got user company",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CompanyDtoResponse.class
                    )
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "User not found / Company not found",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ExceptionDtoResponse.class
                    )
            )
    )
    @GetMapping("/{id}")
    public ResponseEntity<CompanyDtoResponse> get(@PathVariable("id") Long companyId) {
        CompanyDtoResponse companyDtoResponse = companyFacade.get(companyId);
        return ResponseEntity.status(HttpStatus.OK).body(companyDtoResponse);
    }

    @Operation(summary = "Get all user companies")
    @ApiResponse(
            responseCode = "200",
            description = "Got user companies",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CompanyDtoResponse.class
                    )
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "User not found",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ExceptionDtoResponse.class
                    )
            )
    )
    @GetMapping()
    public ResponseEntity<List<CompanyDtoResponse>> getAll() {
        List<CompanyDtoResponse> companyDtoResponses = companyFacade.getAll();
        return ResponseEntity.status((HttpStatus.OK)).body(companyDtoResponses);
    }

    @Operation(summary = "Register new company")
    @ApiResponse(
            responseCode = "201",
            description = "Company created",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CompanyDtoResponse.class
                    )
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "User not found",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ExceptionDtoResponse.class
                    )
            )
    )
    @PostMapping()
    public ResponseEntity<CompanyDtoResponse> add(@RequestBody @Valid CompanyDtoRequest companyDtoRequest) {
        CompanyDtoResponse companyDtoResponse = companyFacade.addCompany(companyDtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(companyDtoResponse);
    }

    @Operation(summary = "Update company")
    @ApiResponse(
            responseCode = "200",
            description = "Company updated",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CompanyDtoResponse.class
                    )
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "User not found / Company not found",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ExceptionDtoResponse.class
                    )
            )
    )
    @PutMapping()
    public ResponseEntity<CompanyDtoResponse> update(@RequestBody @Valid CompanyDtoRequestUpdate companyDtoRequestUpdate) {
        CompanyDtoResponse companyDtoResponse = companyFacade.update(companyDtoRequestUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(companyDtoResponse);
    }

    @Operation(summary = "Update company")
    @ApiResponse(
            responseCode = "204",
            description = "Company removed",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Void.class
                    )
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "User not found / Company not found",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ExceptionDtoResponse.class
                    )
            )
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long companyId) {
        companyFacade.delete(companyId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
