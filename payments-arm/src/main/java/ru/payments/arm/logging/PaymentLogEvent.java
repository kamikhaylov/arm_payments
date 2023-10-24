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
    PAYMENT0006("Ошибка в ответе сервиса получения детальной информации платежа"),
    PAYMENT0007("Вызов сервиса получения системного журнала"),
    PAYMENT0008("Успешный ответ от сервиса получения системного журнала"),
    PAYMENT0009("Ошибка в ответе сервиса получения системного журнала"),
    PAYMENT0010("Вызов сервиса получения метрик мониторинга"),
    PAYMENT0011("Успешный ответ от сервиса получения метрик мониторинга"),
    PAYMENT0012("Ошибка в ответе сервиса получения метрик мониторинга"),
    PAYMENT0013("Не пройдена валидация параметров запроса детальной информации платежа"),
    PAYMENT0014("Не пройдена валидация параметров запроса списка платежей");

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
