package com.sevencows.business.model;

import com.sevencows.business.model.enums.FlowType;
import com.sevencows.business.model.enums.MovementStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_CASH_MOVEMENTS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CashMovement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TBL_CASH_MOVEMENTS")
    @SequenceGenerator(name = "SQ_TBL_CASH_MOVEMENTS", sequenceName = "SQ_TBL_CASH_MOVEMENTS", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movement_type_id")
    private MovementType movementType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movement_id")
    private CashMovement cashMovement;

    @Enumerated(EnumType.STRING)
    @Column(name = "flow_type", nullable = false)
    private FlowType flowType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private MovementStatus movementStatus;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "description", nullable = false, length = 30)
    private String description;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "entry_date_time", nullable = false)
    private LocalDateTime entryDateTime;

    @Column(name = "modify_date_time", nullable = false)
    private LocalDateTime modifyDateTime;

}
