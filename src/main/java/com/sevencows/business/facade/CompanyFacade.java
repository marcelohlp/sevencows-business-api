package com.sevencows.business.facade;

import com.sevencows.business.config.security.AuthenticatedUser;
import com.sevencows.business.dto.company.CompanyDtoRequest;
import com.sevencows.business.dto.company.CompanyDtoRequestUpdate;
import com.sevencows.business.dto.company.CompanyDtoResponse;
import com.sevencows.business.model.Company;
import com.sevencows.business.model.User;
import com.sevencows.business.model.enums.CompanyRole;
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

    public CompanyDtoResponse get(Long companyId) {
        Long userId = authenticatedUser.getUserId();
        Company company = companyService.get(userId, companyId);
        return new CompanyDtoResponse(company);
    }

    public List<CompanyDtoResponse> getAll() {
        Long userId = authenticatedUser.getUserId();
        List<Company> companies = companyService.getAll(userId);
        return companies
                .stream()
                .map(CompanyDtoResponse::new)
                .toList();
    }

    @Transactional
    public CompanyDtoResponse add(CompanyDtoRequest companyDtoRequest) {
        Long userId = authenticatedUser.getUserId();
        User user = userService.findById(userId);
        Company company = companyService.save(companyDtoRequest);
        userCompanyService.add(user, company);
        return new CompanyDtoResponse(company);
    }

    @Transactional
    public CompanyDtoResponse update(CompanyDtoRequestUpdate companyDtoRequestUpdate) {
        Long userId = authenticatedUser.getUserId();
        Long companyId = companyDtoRequestUpdate.id();
        userCompanyService.validUserCompanyAuth(userId, companyId, CompanyRole.ADMIN);
        Company company = companyService.get(userId, companyId);
        company.update(companyDtoRequestUpdate);
        company = companyService.save(company);
        return new CompanyDtoResponse(company);
    }

    @Transactional
    public void delete(Long companyId) {
        Long userId = authenticatedUser.getUserId();
        userCompanyService.validUserCompanyAuth(userId, companyId, CompanyRole.ADMIN);
        Company company = companyService.get(userId, companyId);
        companyService.delete(company);
    }

}
