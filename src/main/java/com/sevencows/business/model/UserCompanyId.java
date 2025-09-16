package com.sevencows.business.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserCompanyId implements Serializable {

    @Column(name = "user_id")
    private Long user;

    @Column(name = "company_id")
    private Long company;

}
