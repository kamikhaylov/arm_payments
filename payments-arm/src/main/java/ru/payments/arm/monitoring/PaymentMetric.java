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
    MONITORING_METRICS_FIND_ERROR("Количество ошибок при работе сервиса получения метрик мониторинга");

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
