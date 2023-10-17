package ru.payments.arm.logging;

import ru.payments.arm.logger.api.LogEvent;

/**
 * События для журналирования.
 */
public enum PaymentLogEvent implements LogEvent {

    PAYMENT1000("Вызов сервиса получения списка платежей");

    private final String title;

    PaymentLogEvent(String title) {
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
        return getCode() + "." + getTitle();
    }
}
