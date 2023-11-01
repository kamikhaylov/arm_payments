package ru.payments.arm.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Модель пользователь
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "users")
public class User {

    /** Идентификатор пользователя */
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Логин */
    private String login;

    /** Пароль */
    private String password;

    /** Почтовый ящик */
    private String email;

    /** Признак доступности учетной записи */
    private boolean enabled;

    /** Роли пользователя */
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_authorities",
            joinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", nullable = false, updatable = false)})
    private Set<Authority> authorities = new HashSet<>();
}
