package com.sevencows.business.model;

import com.sevencows.business.model.enums.CompanyRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_USERS_COMPANIES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserCompany {

    @EmbeddedId
    private UserCompanyId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("user")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("company")
    @JoinColumn(name = "company_id")
    private Company company;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private CompanyRole companyRole;

    public UserCompany(User user, Company company) {
        this.user = user;
        this.company = company;
        this.companyRole = CompanyRole.ADMIN;
        this.id = new UserCompanyId(this.user.getId(), this.getCompany().getId());
    }

}
