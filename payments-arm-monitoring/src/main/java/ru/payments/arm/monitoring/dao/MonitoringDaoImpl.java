package ru.payments.arm.monitoring.dao;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.payments.arm.monitoring.model.MetricModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Реализация взаимодействия с таблицей monitoring_metrics
 */
@Primary
@Repository
@AllArgsConstructor
public class MonitoringDaoImpl implements MonitoringDao {

    @PersistenceContext
    private final EntityManager entityManager;
    private MonitoringCrudDao monitoringCrudDao;

    @Override
    public void save(MetricModel metric) {
        monitoringCrudDao.save(metric);
    }

    @Override
    public List<MetricModel> findFirstOrderIdDesc(int count) {
        return entityManager.createQuery(
                        "select metric from MetricModel metric order by metric.id desc", MetricModel.class)
                       .setMaxResults(count)
                       .getResultList();
    }
}
