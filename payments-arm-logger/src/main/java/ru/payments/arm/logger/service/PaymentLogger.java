package ru.payments.arm.logger.service;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import ru.payments.arm.logger.api.LogEvent;
import ru.payments.arm.logger.model.LogModel;

import java.time.LocalDateTime;

/**
 * Логер.
 */
public class PaymentLogger<T extends LogEvent> {
    private static final String INFO = "INFO";
    private static final String ERROR = "ERROR";

    private final Logger logger;
    private final LoggerService loggerService;

    public PaymentLogger(Logger logger, LoggerService loggerService) {
        this.logger = logger;
        this.loggerService = loggerService;
    }

    /**
     * Логирует события уровня INFO.
     */
    public void info(T event) {
        if (logger.isInfoEnabled()) {
            try {
                logger.info(event.toString());
                loggerService.add(new LogModel(INFO, LocalDateTime.now(),
                        event.toString(), logger.getName()));
            } catch (Exception exc) {
                error(event, exc);
            }
        }
    }

    /**
     * Логирует события уровня ERROR.
     */
    public void error(T event, Throwable throwable) {
        logger.error(event.toString(), throwable);
        loggerService.add(new LogModel(ERROR, LocalDateTime.now(),
                event.toString(), logger.getName()));
    }

    /**
     * Логирует события уровня ERROR.
     */
    public void error(T event, Throwable throwable, String parameter) {
        logger.error(event.toString(), throwable);
        loggerService.add(new LogModel(ERROR, LocalDateTime.now(),
                event.toString(), parameter, logger.getName(), ExceptionUtils.getStackTrace(throwable)));
    }
}
