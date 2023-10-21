package ru.payments.arm.monitoring.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;
import ru.payments.arm.monitoring.api.MonitoringPoint;
import ru.payments.arm.monitoring.dao.MonitoringDao;
import ru.payments.arm.monitoring.model.MetricModel;

import java.util.List;

/**
 * Сервис мониторинга
 */
@Service
public class MonitoringService extends BaseMonitoringService {

    public MonitoringService(MonitoringDao monitoringDao) {
        super(monitoringDao);
    }

    /**
     * Оборачивает мониторингом вызовы сервисов
     *
     * @param point точка мониторинга
     * @param jp    оборачиваемый метод
     * @return возвращает результат выполнения оборачиваемого метода
     */
    public Object wrap(MonitoringPoint point, ProceedingJoinPoint jp) throws Throwable {
        boolean success = false;
        long startTime = notifyStart(point.getStartEvent());
        try {
            Object result = jp.proceed();
            success = true;
            return result;
        } finally {
            notifyFinish(point, success, startTime);
        }
    }

    public List<MetricModel> find() {
        return monitoringDao.findFirstOrderIdDesc(10);
    }
}
