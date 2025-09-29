package com.sevencows.business.validation.usercompany.auth;

import com.sevencows.business.exception.ActionNotAllowedException;
import com.sevencows.business.model.UserCompany;
import com.sevencows.business.model.enums.CompanyRole;
import org.springframework.stereotype.Component;

@Component
public class ValidateUserCompanyRole implements ValidateUserCompanyAuth{

    @Override
    public void valid(UserCompany userCompany, CompanyRole companyRole) {
        CompanyRole role = userCompany.getCompanyRole();
        if (role != companyRole) {
            throw new ActionNotAllowedException("Must be " + role.name() + "!");
        }
    }

}
