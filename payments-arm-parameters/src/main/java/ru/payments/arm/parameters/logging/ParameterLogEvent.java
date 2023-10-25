package ru.payments.arm.parameters.logging;

import ru.payments.arm.logger.api.LogEvent;

/**
 * События для журналирования.
 */
public enum ParameterLogEvent implements LogEvent {

    PAYMENT_PARAMETER_0001("Не найден параметр типа boolean");

    private final String title;

    ParameterLogEvent(String title) {
        this.title = title;
    }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return getCode() + ". " + getTitle();
    }
}
