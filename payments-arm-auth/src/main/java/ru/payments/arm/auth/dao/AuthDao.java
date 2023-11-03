package ru.payments.arm.auth.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.payments.arm.auth.model.Authority;
import ru.payments.arm.auth.model.User;
import ru.payments.arm.auth.model.UserAuthorities;

import java.util.Optional;
import java.util.Set;

/**
 * Интерфейс взаимодействия с таблицей users authorities
 */
@Primary
@Repository
public interface AuthDao {

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

    /**
     * Получение роли по роли
     *
     * @param authority роль
     * @return роль
     */
    Optional<Authority> findByAuthority(String authority);

    /**
     * Сохранение пользователя
     *
     * @param user пользователь
     */
    void save(User user);

    /**
     * Получить роли пользователя по ИД пользователя
     *
     * @param userId ИД пользователя
     */
    Set<UserAuthorities> findUserAuthoritiesByUserId(Integer userId);

    /**
     * Получить роли по списку ИД ролей
     *
     * @param ids список ИД ролей
     */
    Set<Authority> findAuthorityByIdList(@Param("ids") Set<Integer> ids);
}
