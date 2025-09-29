package com.sevencows.business.validation.usercompany.auth;

import com.sevencows.business.model.UserCompany;
import com.sevencows.business.model.enums.CompanyRole;

public interface ValidateUserCompanyAuth {

    void valid(UserCompany userCompany, CompanyRole companyRole);

}
