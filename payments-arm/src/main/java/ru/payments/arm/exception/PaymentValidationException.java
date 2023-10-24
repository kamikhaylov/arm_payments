package ru.payments.arm.exception;

import lombok.Getter;
import ru.payments.arm.logger.api.LogEvent;

@Getter
public class PaymentValidationException extends RuntimeException {

    private static final String FORMAT = "%s. Параметры, не прошедшие валидацию: %s";
    private final LogEvent logEvent;
    private final String arg;

    public PaymentValidationException(LogEvent logEvent, String arg) {
        super(formatMessage(logEvent, arg));
        this.logEvent = logEvent;
        this.arg = arg;
    }

    private static String formatMessage(LogEvent logEvent, String arg) {
        return String.format(FORMAT, logEvent.toString(), arg);
    }
}
