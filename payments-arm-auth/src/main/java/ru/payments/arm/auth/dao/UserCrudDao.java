package ru.payments.arm.auth.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.payments.arm.auth.model.User;

import java.util.Optional;

/**
 * Crud-методы для работы с таблицей users
 */
@Primary
@Repository
public interface UserCrudDao extends CrudRepository<User, Integer> {

    /**
     * Получение пользователя по логину
     *
     * @param login логин
     * @return пользователь
     */
    Optional<User> findByLogin(String login);

    /**
     * Получение пользователя по почтовому ящику
     *
     * @param email почтовый ящик
     * @return пользователь
     */
    Optional<User> findByEmail(String email);
}
