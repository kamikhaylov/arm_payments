package ru.payments.arm.monitoring.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.payments.arm.monitoring.model.MetricModel;

/**
 * Crud-методы для работы с таблицей monitoring_metrics
 */
@Primary
@Repository
public interface MonitoringCrudDao extends CrudRepository<MetricModel, Integer> {

}
