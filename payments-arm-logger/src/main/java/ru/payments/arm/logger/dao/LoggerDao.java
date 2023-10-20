package ru.payments.arm.logger.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.payments.arm.logger.model.LogModel;

import java.util.List;

/**
 * Интерфейс взаимодействия с таблицей system_journal
 */
@Primary
@Repository
public interface LoggerDao {

    /**
     * Сохранение записи лога
     *
     * @param log лог
     */
    void save(LogModel log);


    /**
     * Получить последние count записей
     *
     * @param count количество запрашиваемых записей
     * @return список записей
     */
    List<LogModel> findFirstOrderIdDesc(int count);
}
