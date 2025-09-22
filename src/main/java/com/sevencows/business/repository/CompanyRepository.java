package com.sevencows.business.repository;

import java.util.List;

import com.sevencows.business.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("""
        SELECT c
        FROM Company c
        INNER JOIN c.userCompanyList uc
        WHERE uc.user.id = :userId
    """)
    List<Company> findByUserId(@Param("userId") Long userId);

}
