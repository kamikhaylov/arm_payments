package ru.payments.arm.parameters.exception;

import lombok.Getter;
import ru.payments.arm.logger.api.LogEvent;

@Getter
public class ParameterException extends RuntimeException {

    private static final String FORMAT = "%s. Не найденный параметр: %s";

    private LogEvent logEvent;
    private String arg;

    public ParameterException(LogEvent logEvent, String arg) {
        super(formatMessage(logEvent, arg));
        this.logEvent = logEvent;
        this.arg = arg;
    }

    private static String formatMessage(LogEvent logEvent, String arg) {
        return String.format(FORMAT, logEvent.toString(), arg);
    }
}
