package ru.payments.arm.auth.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.payments.arm.auth.model.Authority;

import java.util.Optional;
import java.util.Set;

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

    /**
     * Получить роли по списку ИД ролей
     *
     * @param ids список ИД ролей
     */
    @Query("from Authority where id in :ids")
    Set<Authority> findByIdList(@Param("ids") Set<Integer> ids);
}
