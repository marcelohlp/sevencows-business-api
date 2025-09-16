package com.sevencows.business.service;

import com.sevencows.business.config.security.AuthenticatedUser;
import com.sevencows.business.dto.company.CompanyDtoRequest;
import com.sevencows.business.dto.company.CompanyDtoResponse;
import com.sevencows.business.model.Company;
import com.sevencows.business.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewCompanyTransactionService {

    private final CompanyService companyService;
    private final AuthenticatedUser authenticatedUser;
    private final UserService userService;
    private final UserCompanyService userCompanyService;

    public NewCompanyTransactionService(
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

    @Transactional
    public CompanyDtoResponse addCompany(CompanyDtoRequest companyDtoRequest) {
        Long userId = authenticatedUser.getUserId();
        User user = userService.findById(userId);
        Company company = companyService.addCompany(companyDtoRequest);
        userCompanyService.addUserCompany(user, company);
        return new CompanyDtoResponse(company);
    }

}
