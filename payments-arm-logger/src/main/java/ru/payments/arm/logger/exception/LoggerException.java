package ru.payments.arm.logger.exception;

import ru.payments.arm.logger.api.LogEvent;

public class LoggerException extends PaymentBaseException {

    public LoggerException(LogEvent logEvent) {
        super(logEvent);
    }

    public LoggerException(LogEvent logEvent, String arg) {
        super(logEvent, arg);
    }
}
