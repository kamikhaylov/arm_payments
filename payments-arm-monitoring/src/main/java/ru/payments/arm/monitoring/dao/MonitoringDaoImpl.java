package ru.payments.arm.monitoring.dao;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.payments.arm.logger.exception.PaymentException;
import ru.payments.arm.monitoring.model.MetricModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

import static ru.payments.arm.monitoring.logging.MonitoringLogEvent.MON0001;
import static ru.payments.arm.monitoring.logging.MonitoringLogEvent.MON0002;

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

    @Transactional
    @Override
    public void save(MetricModel metric) {
        try {
            monitoringCrudDao.save(metric);
        } catch (Exception exc) {
            throw new PaymentException(MON0001, metric.getCode());
        }
    }

    @Override
    public List<MetricModel> findFirstOrderIdDesc(int count) {
        try {
            return entityManager.createQuery(
                            "select metric from MetricModel metric order by metric.id desc", MetricModel.class)
                           .setMaxResults(count)
                           .getResultList();
        } catch (Exception exc) {
            throw new PaymentException(MON0002);
        }
    }
}
