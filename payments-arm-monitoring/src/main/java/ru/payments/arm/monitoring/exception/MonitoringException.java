package ru.payments.arm.monitoring.exception;

import ru.payments.arm.logger.api.LogEvent;
import ru.payments.arm.logger.exception.PaymentBaseException;

public class MonitoringException extends PaymentBaseException {

    public MonitoringException(LogEvent logEvent) {
        super(logEvent);
    }

    public MonitoringException(LogEvent logEvent, String arg) {
        super(logEvent, arg);
    }
}
