package com.sevencows.business.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TBL_USERS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TBL_USERS")
    @SequenceGenerator(name = "SQ_TBL_USERS", sequenceName = "SQ_TBL_USERS", allocationSize = 1)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Column(name = "email", nullable = false, length = 120)
    private String email;

    @Column(name = "password", nullable = false, length = 120)
    private String password;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "entry_date_time", nullable = false)
    private LocalDateTime entryDateTime;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserPreferences userPreferences;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserCompany> userCompanyList;

}
