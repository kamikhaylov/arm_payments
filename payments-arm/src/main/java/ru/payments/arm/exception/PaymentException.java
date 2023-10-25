package ru.payments.arm.exception;

import lombok.Getter;
import ru.payments.arm.logger.api.LogEvent;

@Getter
public class PaymentException extends RuntimeException {

    private static final String FORMAT = "%s. %s";

    private LogEvent logEvent;
    private String arg;

    public PaymentException(LogEvent logEvent) {
        super(logEvent.toString());
        this.logEvent = logEvent;
    }

    public PaymentException(LogEvent logEvent, String arg) {
        super(formatMessage(logEvent, arg));
        this.logEvent = logEvent;
        this.arg = arg;
    }

    private static String formatMessage(LogEvent logEvent, String arg) {
        return String.format(FORMAT, logEvent.toString(), arg);
    }
}
