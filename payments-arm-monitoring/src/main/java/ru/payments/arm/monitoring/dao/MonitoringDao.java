package ru.payments.arm.monitoring.dao;

import ru.payments.arm.monitoring.model.MetricModel;

import java.util.List;

/**
 * Интерфейс взаимодействия с таблицей monitoring_metrics
 */
public interface MonitoringDao {

    /**
     * Сохранение события со значением.
     *
     * @param metric метрика мониторинга
     */
    void save(MetricModel metric);


    /**
     * Получить последние count метрик
     *
     * @param count количество запрашиваемых метрик
     * @return список метрик
     */
    List<MetricModel> findFirstOrderIdDesc(int count);
}
