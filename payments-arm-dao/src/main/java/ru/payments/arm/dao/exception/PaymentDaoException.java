package ru.payments.arm.dao.exception;

import ru.payments.arm.logger.api.LogEvent;
import ru.payments.arm.logger.exception.PaymentBaseException;

public class PaymentDaoException extends PaymentBaseException {

    public PaymentDaoException(LogEvent logEvent) {
        super(logEvent);
    }

    public PaymentDaoException(LogEvent logEvent, String arg) {
        super(logEvent, arg);
    }
}
