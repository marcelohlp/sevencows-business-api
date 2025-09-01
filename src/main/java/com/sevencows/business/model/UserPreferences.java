package com.sevencows.business.model;

import com.sevencows.business.model.enums.Gender;
import com.sevencows.business.model.enums.Pronoun;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_USER_PREFERENCES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserPreferences {

    @Id
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "user_timezone", nullable = false, length = 60)
    private String userTimezone;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "pronoun")
    private Pronoun pronoun;

    @Column(name = "preferred_name", nullable = false, length = 30)
    private String preferredName;

    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(name = "id")
    private User user;

}
