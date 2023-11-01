package ru.payments.arm.logger.exception;

import lombok.Getter;
import ru.payments.arm.logger.api.LogEvent;
import ru.payments.arm.logger.exception.PaymentBaseException;

@Getter
public class PaymentException extends PaymentBaseException {

    public PaymentException(LogEvent logEvent) {
        super(logEvent);
    }

    public PaymentException(LogEvent logEvent, String arg) {
        super(logEvent, arg);
    }

    public PaymentException(LogEvent logEvent, Throwable cause, String arg) {
        super(logEvent, cause, arg);
    }
}
