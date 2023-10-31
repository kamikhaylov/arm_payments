package ru.payments.arm.auth.exception;

import ru.payments.arm.logger.api.LogEvent;
import ru.payments.arm.logger.exception.PaymentBaseException;

public class AuthException extends PaymentBaseException {

    public AuthException(LogEvent logEvent) {
        super(logEvent);
    }

    public AuthException(LogEvent logEvent, String arg) {
        super(logEvent, arg);
    }
}
