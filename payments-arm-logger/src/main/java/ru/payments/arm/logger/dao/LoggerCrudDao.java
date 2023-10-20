package ru.payments.arm.logger.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.payments.arm.logger.model.LogModel;

/**
 * Crud-методы для работы с таблицей system_journal
 */
@Primary
@Repository
public interface LoggerCrudDao extends CrudRepository<LogModel, Integer> {

}
