package ru.payments.arm.logger.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.payments.arm.logger.model.LogModel;

/**
 * Интерфейс взаимодействия с БД журналирования
 */
@Primary
@Repository
public interface LoggerDao extends CrudRepository<LogModel, Integer> {

}
