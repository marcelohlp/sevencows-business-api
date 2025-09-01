package com.sevencows.business.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "TBL_MONTHS_END_CLOSING")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MonthEndClosing {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TBL_MONTHS_END_CLOSING")
    @SequenceGenerator(name = "SQ_TBL_MONTHS_END_CLOSING", sequenceName = "SQ_TBL_MONTHS_END_CLOSING", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "year", nullable = false)
    private Short year;

    @Column(name = "month", nullable = false)
    private Byte month;

    @Column(name = "opening_balance", nullable = false)
    private BigDecimal openingBalance;

    @Column(name = "closing_balance", nullable = false)
    private BigDecimal closingBalance;

}
