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
    PAYMENT0014("Не пройдена валидация параметров запроса списка платежей"),
    PAYMENT0015("Не пройдена валидация параметров запроса метрик монторинга"),
    PAYMENT0016("Не пройдена валидация параметров запроса записей системного журнала"),
    PAYMENT0017("Сервис получения списка платежей отключен"),
    PAYMENT0018("Сервис получения детальной информации отключен"),
    PAYMENT0019("Сервис получения метрик мониторинга отключен"),
    PAYMENT0020("Сервис получения записей системного журнала отключен"),
    PAYMENT0021("Вызов сервиса получения списка типов платежей"),
    PAYMENT0022("Успешный ответ от сервиса получения списка типов платежей"),
    PAYMENT0023("Ошибка в ответе сервиса получения списка типов платежей"),
    PAYMENT0024("Сервис получения списка типов платежей отключен"),
    PAYMENT0025("Не пройдена валидация параметров запроса списка типов платежей"),
    PAYMENT0026("Вызов сервиса вставки типа платежа"),
    PAYMENT0027("Успешный ответ от сервиса вставки типа платежа"),
    PAYMENT0028("Ошибка в ответе сервиса вставки типа платежа"),
    PAYMENT0029("Сервис вставки типа платежа отключен"),
    PAYMENT0030("Не пройдена валидация параметров запроса вставки типа платежа"),
    PAYMENT0031("Вызов сервиса удаления типа платежа"),
    PAYMENT0032("Успешный ответ от сервиса удаления типа платежа"),
    PAYMENT0033("Ошибка в ответе сервиса удаления типа платежа"),
    PAYMENT0034("Сервис удаления типа платежа отключен"),
    PAYMENT0035("Не пройдена валидация параметров запроса удаления типа платежа"),
    PAYMENT0036("Не пройдена валидация параметров запроса регистрации пользователя"),
    PAYMENT0037("Вызов сервиса регистрации пользователя"),
    PAYMENT0038("Успешный ответ от сервиса регистрации пользователя"),
    PAYMENT0039("Ошибка в ответе сервиса регистрации пользователя"),
    PAYMENT0040("Сервис регистрации пользователя отключен");

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
