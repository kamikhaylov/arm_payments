package ru.payments.arm.logging;

import ru.payments.arm.logger.api.LogEvent;

/**
 * События для журналирования.
 */
public enum PaymentLogEvent implements LogEvent {

    PAYMENT0001("Вызов сервиса получения списка платежей"),
    PAYMENT0002("Успешный ответ от сервиса получения списка платежей"),
    PAYMENT0003("Ошибка в ответе сервиса получения списка платежей"),
    PAYMENT0004("Вызов сервиса получения детальной информации платежа"),
    PAYMENT0005("Успешный ответ от сервиса получения детальной информации платежа"),
    PAYMENT0006("Ошибка в ответе сервиса получения детальной информации платежа");

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
        return getCode() + ". " + getTitle();
    }
}
