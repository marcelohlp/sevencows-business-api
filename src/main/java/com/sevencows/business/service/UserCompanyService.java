package com.sevencows.business.service;

import com.sevencows.business.model.Company;
import com.sevencows.business.model.User;
import com.sevencows.business.model.UserCompany;
import com.sevencows.business.model.enums.CompanyRole;
import com.sevencows.business.repository.UserCompanyRepository;
import com.sevencows.business.util.OptionalContentExtractor;
import com.sevencows.business.validation.usercompany.auth.ValidateUserCompanyAuth;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCompanyService {

    private final UserCompanyRepository userCompanyRepository;
    private final List<ValidateUserCompanyAuth> validateUserCompanyAuth;
    private final OptionalContentExtractor optionalContentExtractor;

    public UserCompanyService(
            UserCompanyRepository userCompanyRepository,
            List<ValidateUserCompanyAuth> validateUserCompanyAuth,
            OptionalContentExtractor optionalContentExtractor
    ) {
        this.userCompanyRepository = userCompanyRepository;
        this.validateUserCompanyAuth = validateUserCompanyAuth;
        this.optionalContentExtractor = optionalContentExtractor;
    }

    public UserCompany get(Long userId, Long companyId) {
        Optional<UserCompany> optional = userCompanyRepository.findByUserIdAndCompanyId(userId, companyId);
        String errorMessage = "User company authorities not found!";
        return optionalContentExtractor.getOrThrows(optional, errorMessage);
    }

    public UserCompany add(User user, Company company) {
        UserCompany userCompany = new UserCompany(user, company);
        return userCompanyRepository.save(userCompany);
    }

    public void validUserCompanyAuth(Long userId, Long companyId, CompanyRole companyRole) {
        UserCompany userCompany = get(userId, companyId);
        validateUserCompanyAuth.forEach(
                validator -> validator.valid(userCompany, companyRole)
        );
    }


}
