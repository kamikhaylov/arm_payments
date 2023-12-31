package ru.payments.arm.logger.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.payments.arm.logger.dao.LoggerDao;
import ru.payments.arm.logger.model.LogModel;

import java.util.List;

/**
 * Сервис логера
 */
@Service
@AllArgsConstructor
public class LoggerService {

    private final LoggerDao loggerDao;

    /**
     * Добавление лога.
     * @param log - лог
     */
    public void add(LogModel log) {
        loggerDao.save(log);
    }

    public List<LogModel> findAll() {
        return loggerDao.findFirstOrderIdDesc(10);
    }
}
