package ru.payments.arm.logger.dao;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.payments.arm.logger.exception.LoggerException;
import ru.payments.arm.logger.model.LogModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

import static ru.payments.arm.logger.logging.LoggerLogEvent.LOG0001;
import static ru.payments.arm.logger.logging.LoggerLogEvent.LOG0002;

/**
 * Реализация взаимодействия с таблицей system_journal
 */
@Primary
@Repository
@AllArgsConstructor
public class LoggerDaoImpl implements LoggerDao {

    @PersistenceContext
    private final EntityManager entityManager;
    private final LoggerCrudDao loggerCrudDao;

    @Transactional
    @Override
    public void save(LogModel log) {
        try {
            loggerCrudDao.save(log);
        } catch (Exception ex) {
            throw new LoggerException(LOG0001, log.getMessage());
        }
    }

    @Override
    public List<LogModel> findFirstOrderIdDesc(int count) {
        try {
            return entityManager.createQuery(
                            "select log from LogModel log order by log.id desc", LogModel.class)
                           .setMaxResults(count)
                           .getResultList();
        } catch (Exception ex) {
            throw new LoggerException(LOG0002);
        }
    }
}
