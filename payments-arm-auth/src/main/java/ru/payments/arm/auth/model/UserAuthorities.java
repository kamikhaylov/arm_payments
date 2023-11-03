package ru.payments.arm.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Модель - выданные роли пользователям
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_authorities")
public class UserAuthorities {

    /** Идентификатор выданной роли */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Идентификатор пользователя */
    @Column(name = "user_id")
    private Integer userId;

    /** Идентификатор роли */
    @Column(name = "authority_id")
    private Integer authorityId;
}
