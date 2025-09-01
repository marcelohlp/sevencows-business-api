package com.sevencows.business.model;

import com.sevencows.business.model.enums.FlowType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TBL_MOVEMENT_TYPES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MovementType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TBL_MOVEMENT_TYPES")
    @SequenceGenerator(name = "SQ_TBL_MOVEMENT_TYPES", sequenceName = "SQ_TBL_MOVEMENT_TYPES", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id")
    private Company company;

    @Enumerated(EnumType.STRING)
    @Column(name = "flow_type", nullable = false)
    private FlowType flowType;

    @Column(name = "description", nullable = false, length = 30)
    private String description;

    @Column(name = "entry_date_time", nullable = false)
    private LocalDateTime entryDateTime;

    @Column(name = "modify_date_time", nullable = false)
    private LocalDateTime modifyDateTime;

    @OneToMany(mappedBy = "movementType", cascade = CascadeType.ALL)
    private List<CashMovement> cashMovementList;

}
