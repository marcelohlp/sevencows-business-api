package com.sevencows.business.facade;

import com.sevencows.business.config.security.AuthenticatedUser;
import com.sevencows.business.dto.company.CompanyDtoRequest;
import com.sevencows.business.dto.company.CompanyDtoResponse;
import com.sevencows.business.model.Company;
import com.sevencows.business.model.User;
import com.sevencows.business.service.UserCompanyService;
import com.sevencows.business.service.UserService;
import com.sevencows.business.service.CompanyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyFacade {

    private final CompanyService companyService;
    private final AuthenticatedUser authenticatedUser;
    private final UserService userService;
    private final UserCompanyService userCompanyService;

    public CompanyFacade(
            CompanyService companyService,
            AuthenticatedUser authenticatedUser,
            UserService userService,
            UserCompanyService userCompanyService
    ) {
        this.companyService = companyService;
        this.authenticatedUser = authenticatedUser;
        this.userService = userService;
        this.userCompanyService = userCompanyService;
    }

    public List<CompanyDtoResponse> getAll() {
        Long userId = authenticatedUser.getUserId();
        List<Company> companies = companyService.getAll(userId);
        List<CompanyDtoResponse> companyDtoResponses = companies
                .stream()
                .map(CompanyDtoResponse::new)
                .toList();
        return companyDtoResponses;
    }

    @Transactional
    public CompanyDtoResponse addCompany(CompanyDtoRequest companyDtoRequest) {
        Long userId = authenticatedUser.getUserId();
        User user = userService.findById(userId);
        Company company = companyService.addCompany(companyDtoRequest);
        userCompanyService.addUserCompany(user, company);
        return new CompanyDtoResponse(company);
    }

}
