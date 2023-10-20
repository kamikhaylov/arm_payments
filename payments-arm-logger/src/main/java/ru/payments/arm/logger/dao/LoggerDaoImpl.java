package ru.payments.arm.logger.dao;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.payments.arm.logger.model.LogModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    @Override
    public void save(LogModel log) {
        loggerCrudDao.save(log);
    }

    @Override
    public List<LogModel> findFirstOrderIdDesc(int count) {
        return entityManager.createQuery(
                        "select log from LogModel log order by log.id desc", LogModel.class)
                       .setMaxResults(count)
                       .getResultList();
    }
}
