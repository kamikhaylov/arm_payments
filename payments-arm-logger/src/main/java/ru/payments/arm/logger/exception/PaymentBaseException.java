package ru.payments.arm.logger.exception;

import lombok.Getter;
import ru.payments.arm.logger.api.LogEvent;

@Getter
public class PaymentBaseException extends RuntimeException implements LogException {

    private static final String FORMAT = "%s. %s";

    private LogEvent logEvent;
    private String arg;

    public PaymentBaseException(LogEvent logEvent) {
        super(logEvent.toString());
        this.logEvent = logEvent;
    }

    public PaymentBaseException(LogEvent logEvent, String arg) {
        super(formatMessage(logEvent, arg));
        this.logEvent = logEvent;
        this.arg = arg;
    }

    public PaymentBaseException(LogEvent logEvent, Throwable cause, String arg) {
        super(formatMessage(logEvent, arg), cause);
        this.logEvent = logEvent;
        this.arg = arg;
    }

    private static String formatMessage(LogEvent logEvent, String arg) {
        return String.format(FORMAT, logEvent.toString(), arg);
    }
}
