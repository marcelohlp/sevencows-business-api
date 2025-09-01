package com.sevencows.business.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_CASH_DAILY_RESULTS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CashDailyResult {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TBL_CASH_DAILY_RESULTS")
    @SequenceGenerator(name = "SQ_TBL_CASH_DAILY_RESULTS", sequenceName = "SQ_TBL_CASH_DAILY_RESULTS", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "reference_date", nullable = false)
    private LocalDate referenceDate;

    @Column(name = "total_inflows", nullable = false)
    private BigDecimal totalInflows;

    @Column(name = "total_outflows", nullable = false)
    private BigDecimal totalOutflows;

    @Column(name = "daily_result", nullable = false)
    private BigDecimal dailyResult;

    @Column(name = "modify_date_time", nullable = false)
    private LocalDateTime modifyDateTime;

}
