package com.sevencows.business.model;

import com.sevencows.business.model.enums.CompanyType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TBL_COMPANIES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Company {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TBL_COMPANIES")
    @SequenceGenerator(name = "SQ_TBL_COMPANIES", sequenceName = "SQ_TBL_COMPANIES", allocationSize = 1)
    private Long id;

    @Column(name = "trade_name", nullable = false, length = 60)
    private String tradeName;

    @Column(name = "legal_name", length = 60)
    private String legalName;

    @Enumerated(EnumType.STRING)
    @Column(name = "company_type", nullable = false)
    private CompanyType companyType;

    @Column(name = "incorporation_date")
    private LocalDate incorporationDate;

    @Column(name = "entry_date_time", nullable = false)
    private LocalDateTime entryDateTime;

    @Column(name = "modify_date_time", nullable = false)
    private LocalDateTime modifyDateTime;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<UserCompany> userCompanyList;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<MovementType> movementTypeList;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<CashMovement> cashMovementList;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<MonthEndClosing> monthEndClosingList;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<CashDailyResult> cashDailyResultList;
}
