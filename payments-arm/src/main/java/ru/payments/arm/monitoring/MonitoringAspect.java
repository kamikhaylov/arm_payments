package ru.payments.arm.monitoring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.payments.arm.monitoring.service.MonitoringService;

/**
 * Аспект мониторинга сервисов и времени выполнения событий.
 */
@Aspect
@Order(0)
@Component
public class MonitoringAspect {
    private final MonitoringService monitoringService;

    public MonitoringAspect(@Qualifier("monitoringService")
                                          MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    @Pointcut("execution(public * ru.payments.arm.controller..*Controller*.*(..))")
    public void callService() {

    }

    @Around("callService() && @annotation(monitored)")
    public Object call(ProceedingJoinPoint jp, PaymentMonitored monitored) throws Throwable {
        return monitoringService.wrap(monitored.value(), jp);
    }
}
