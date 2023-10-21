package ru.payments.arm.monitoring.service;

import ru.payments.arm.monitoring.api.Metric;
import ru.payments.arm.monitoring.api.MonitoringPoint;

/**
 * Интерфейс сервиса по работе с мониторингом
 */
public interface Monitoring {

    /**
     * Уведомление о вызове сервиса.
     * @param metric метрика мониторинга
     * @return системное время на момент вызова (в мс)
     */
    long notifyStart(Metric metric);

    /**
     * Уведомление о завершении вызова сервиса.
     * @param point точка мониторинга
     * @param success true - успешный вызов, false - нет
     * @param requestTime системное время в мс
     */
    void notifyFinish(MonitoringPoint point, boolean success, long requestTime);

    /**
     * Уведомление о длительности вызова сервиса.
     * @param metric метрика мониторинга
     * @param startTime системное время в мс
     */
    void notifyDuration(Metric metric, long startTime);

    /**
     * Публикация события.
     * @param metric метрика мониторинга
     */
    void reportEvent(Metric metric);

    /**
     * Публикация события со значением.
     * @param metric метрика мониторинга
     * @param value наблюдаемое значение
     */
    void reportEvent(Metric metric, double value);
}
