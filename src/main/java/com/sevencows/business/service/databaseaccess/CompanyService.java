package com.sevencows.business.service.databaseaccess;

import com.sevencows.business.dto.company.CompanyDtoRequest;
import com.sevencows.business.model.Company;
import com.sevencows.business.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company addCompany(CompanyDtoRequest companyDtoRequest) {
        Company company = new Company(companyDtoRequest);
        company = companyRepository.save(company);
        return company;
    }

}
