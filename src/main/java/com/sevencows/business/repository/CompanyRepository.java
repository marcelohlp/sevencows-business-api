package com.sevencows.business.repository;

import java.util.List;
import java.util.Optional;

import com.sevencows.business.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("""
            SELECT c
                FROM Company c
                INNER JOIN c.userCompanyList uc
                WHERE c.id = :companyId
                AND uc.user.id = :userId
            """)
    Optional<Company> findByUserIdAndCompanyId(@Param("userId") Long userId,
                                               @Param("companyId") Long companyId);

    @Query("""
                SELECT c
                FROM Company c
                INNER JOIN c.userCompanyList uc
                WHERE uc.user.id = :userId
            """)
    List<Company> findByUserId(@Param("userId") Long userId);

}
