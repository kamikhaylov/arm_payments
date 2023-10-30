package ru.payments.arm.exception;

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
}
