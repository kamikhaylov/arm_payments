package ru.payments.arm.auth.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.payments.arm.auth.model.Authority;

import java.util.Optional;

/**
 * Интерфейс взаимодействия с таблицей authorities
 */
@Primary
@Repository
public interface AuthorityCrudDao extends CrudRepository<Authority, Integer> {

    /**
     * Получение роли по роли
     *
     * @param authority роль
     * @return роль
     */
    Optional<Authority> findByAuthority(String authority);
}
