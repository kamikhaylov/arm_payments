package ru.payments.arm.monitoring.service;

import lombok.AllArgsConstructor;
import ru.payments.arm.monitoring.api.Metric;
import ru.payments.arm.monitoring.api.MonitoringPoint;
import ru.payments.arm.monitoring.dao.MonitoringDao;
import ru.payments.arm.monitoring.model.MetricModel;

import java.time.LocalDateTime;

/**
 * Базовый сервис мониторинга
 */
@AllArgsConstructor
public class BaseMonitoringService implements Monitoring {

    protected final MonitoringDao monitoringDao;

    /**
     * Уведомление о вызове сервиса.
     *
     * @param metric метрика мониторинга
     * @return системное время на момент вызова (в мс)
     */
    @Override
    public long notifyStart(Metric metric) {
        reportEvent(metric);
        return System.currentTimeMillis();
    }

    /**
     * Уведомление о завершении вызова сервиса.
     *
     * @param point       точка мониторинга
     * @param success     true - успешный вызов, false - нет
     * @param requestTime системное время в мс
     */
    @Override
    public void notifyFinish(MonitoringPoint point, boolean success, long requestTime) {
        notifyDuration(point.getDurationEvent(), requestTime);
        if (success) {
            reportEvent(point.getSuccessEvent());
        } else {
            reportEvent(point.getErrorEvent());
        }
    }

    /**
     * Уведомление о длительности вызова сервиса.
     *
     * @param metric    метрика мониторинга
     * @param startTime системное время в мс
     */
    @Override
    public void notifyDuration(Metric metric, long startTime) {
        monitoringDao.save(createMetricModel(metric, System.currentTimeMillis() - startTime));
    }

    /**
     * Публикация события.
     *
     * @param metric метрика мониторинга
     */
    @Override
    public void reportEvent(Metric metric) {
        reportEvent(metric, 1.0D);
    }

    /**
     * Публикация события со значением.
     *
     * @param metric метрика мониторинга
     * @param value  наблюдаемое значение
     */
    @Override
    public void reportEvent(Metric metric, double value) {
        monitoringDao.save(createMetricModel(metric, value));
    }

    protected MetricModel createMetricModel(Metric metric, double value) {
        MetricModel metricModel = new MetricModel();
        metricModel.setCode(metric.getCode());
        metricModel.setName(metric.getTitle());
        metricModel.setCreated(LocalDateTime.now());
        metricModel.setValue(value);
        return metricModel;
    }
}
