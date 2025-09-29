package com.sevencows.business.repository;

import com.sevencows.business.model.UserCompany;
import com.sevencows.business.model.UserCompanyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserCompanyRepository extends JpaRepository<UserCompany, UserCompanyId> {

    @Query("""
            SELECT uc
            FROM UserCompany uc
            WHERE uc.user.id = :userId
            AND uc.company.id = :companyId
            """)
    Optional<UserCompany> findByUserIdAndCompanyId(@Param("userId") Long userId,
                                                   @Param("companyId") Long companyId);

}
