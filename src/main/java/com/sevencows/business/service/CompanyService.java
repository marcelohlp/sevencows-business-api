package com.sevencows.business.service;

import com.sevencows.business.dto.company.CompanyDtoRequest;
import com.sevencows.business.model.Company;
import com.sevencows.business.repository.CompanyRepository;
import com.sevencows.business.util.OptionalContentExtractor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final OptionalContentExtractor optionalContentExtractor;

    public CompanyService(
            CompanyRepository companyRepository,
            OptionalContentExtractor optionalContentExtractor) {
        this.companyRepository = companyRepository;
        this.optionalContentExtractor = optionalContentExtractor;
    }

    public Company get(Long userId, Long companyId) {
        Optional<Company> optional =
                companyRepository.findByUserIdAndCompanyId(userId, companyId);
        String errorMessage = "Company not found by id: " + companyId;
        return optionalContentExtractor.getOrThrows(optional, errorMessage);
    }

    public List<Company> getAll(Long userId) {
        return companyRepository.findByUserId(userId);
    }

    public Company save(CompanyDtoRequest companyDtoRequest) {
        Company company = new Company(companyDtoRequest);
        company = companyRepository.save(company);
        return company;
    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }

}
