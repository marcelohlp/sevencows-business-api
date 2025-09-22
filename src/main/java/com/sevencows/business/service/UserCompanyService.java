package com.sevencows.business.service;

import com.sevencows.business.model.Company;
import com.sevencows.business.model.User;
import com.sevencows.business.model.UserCompany;
import com.sevencows.business.repository.UserCompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCompanyService {

    private final UserCompanyRepository userCompanyRepository;

    public UserCompanyService(UserCompanyRepository userCompanyRepository) {
        this.userCompanyRepository = userCompanyRepository;
    }

    public UserCompany addUserCompany(User user, Company company) {
        UserCompany userCompany = new UserCompany(user, company);
        userCompany = userCompanyRepository.save(userCompany);
        return  userCompany;
    }

}
