package ru.payments.arm.monitoring;

import ru.payments.arm.monitoring.api.Metric;

/**
 * Метрики мониторинга
 */
public enum PaymentMetric implements Metric {

    PAYMENT_LIST_FIND_REQUEST("Количество вызовов сервиса получения списка платежей"),
    PAYMENT_LIST_FIND_DURATION("Длительность ответа сервиса получения платежей"),
    PAYMENT_LIST_FIND_SUCCESS("Количество успешных вызовов сервиса получения платежей"),
    PAYMENT_LIST_FIND_ERROR("Количество ошибок при работе сервиса получения платежей"),

    PAYMENT_DETAILS_FIND_REQUEST("Количество вызовов сервиса получения детальной информации платежа"),
    PAYMENT_DETAILS_FIND_DURATION("Длительность ответа сервиса детальной информации"),
    PAYMENT_DETAILS_FIND_SUCCESS("Количество успешных вызовов сервиса детальной информации"),
    PAYMENT_DETAILS_FIND_ERROR("Количество ошибок при работе сервиса детальной информации"),

    SYSTEM_JOURNAL_FIND_REQUEST("Количество вызовов сервиса получения записей системного журнала"),
    SYSTEM_JOURNAL_FIND_DURATION("Длительность ответа сервиса получения записей системного журнала"),
    SYSTEM_JOURNAL_FIND_SUCCESS("Количество успешных вызовов сервиса получения записей системного журнала"),
    SYSTEM_JOURNAL_FIND_ERROR("Количество ошибок при работе сервиса получения записей системного журнала"),

    MONITORING_METRICS_FIND_REQUEST("Количество вызовов сервиса получения метрик мониторинга"),
    MONITORING_METRICS_FIND_DURATION("Длительность ответа сервиса получения метрик мониторинга"),
    MONITORING_METRICS_FIND_SUCCESS("Количество успешных вызовов сервиса получения метрик мониторинга"),
    MONITORING_METRICS_FIND_ERROR("Количество ошибок при работе сервиса получения метрик мониторинга"),

    PAYMENT_TYPE_LIST_FIND_REQUEST("Количество вызовов сервиса получения списка типов платежей"),
    PAYMENT_TYPE_LIST_FIND_DURATION("Длительность ответа сервиса получения типов платежей"),
    PAYMENT_TYPE_LIST_FIND_SUCCESS("Количество успешных вызовов сервиса получения типов платежей"),
    PAYMENT_TYPE_LIST_FIND_ERROR("Количество ошибок при работе сервиса получения типов платежей"),

    PAYMENT_MERGE_TYPE_REQUEST("Количество вызовов сервиса вставки типа платежа"),
    PAYMENT_MERGE_TYPE_DURATION("Длительность ответа сервиса вставки типа платежа"),
    PAYMENT_MERGE_TYPE_SUCCESS("Количество успешных вызовов сервиса вставки типа платежа"),
    PAYMENT_MERGE_TYPE_ERROR("Количество ошибок при работе сервиса вставки типа платежа"),

    PAYMENT_DELETE_TYPE_REQUEST("Количество вызовов сервиса удаления типа платежа"),
    PAYMENT_DELETE_TYPE_DURATION("Длительность ответа сервиса удаления типа платежа"),
    PAYMENT_DELETE_TYPE_SUCCESS("Количество успешных вызовов сервиса удаления типа платежа"),
    PAYMENT_DELETE_TYPE_ERROR("Количество ошибок при работе сервиса удаления типа платежа"),

    REGISTRATION_SIGN_UP_REQUEST("Количество вызовов сервиса регистрации пользователя"),
    REGISTRATION_SIGN_UP_DURATION("Длительность ответа сервиса регистрации пользователя"),
    REGISTRATION_SIGN_UP_SUCCESS("Количество успешных вызовов сервиса регистрации пользователя"),
    REGISTRATION_SIGN_UP_ERROR("Количество ошибок при работе сервиса регистрации пользователя");

    private final String title;

    PaymentMetric(String title) {
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
