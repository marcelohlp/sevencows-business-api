package com.sevencows.business.repository;

import com.sevencows.business.model.UserCompany;
import com.sevencows.business.model.UserCompanyId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCompanyRepository extends JpaRepository<UserCompany, UserCompanyId> {
}
