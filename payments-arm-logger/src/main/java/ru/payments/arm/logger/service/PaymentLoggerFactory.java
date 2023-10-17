package ru.payments.arm.logger.service;

import org.slf4j.LoggerFactory;
import ru.payments.arm.logger.api.LogEvent;

/**
 * Фабрика логера
 */
public class PaymentLoggerFactory {

    private PaymentLoggerFactory() {
    }

    public static <T extends LogEvent> PaymentLogger<T> getLogger(Class<?> type,
                                                                  LoggerService loggerService) {
        return new PaymentLogger<>(LoggerFactory.getLogger(type), loggerService);
    }
}
