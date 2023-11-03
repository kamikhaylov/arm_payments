package ru.payments.arm.auth.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.payments.arm.auth.model.UserAuthorities;

import java.util.Set;

/**
 * Crud-методы для работы с таблицей user_authorities
 */
@Primary
@Repository
public interface UserAuthoritiesCrudDao extends CrudRepository<UserAuthorities, Integer> {

    /**
     * Получить роли пользователя по ИД пользователя
     *
     * @param userId ИД пользователя
     */
    Set<UserAuthorities> findAllByUserId(Integer userId);
}
