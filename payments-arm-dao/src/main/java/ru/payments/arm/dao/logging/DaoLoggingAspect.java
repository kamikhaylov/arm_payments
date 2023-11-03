package ru.payments.arm.dao.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.payments.arm.logger.api.LogEvent;
import ru.payments.arm.logger.exception.PaymentException;
import ru.payments.arm.logger.service.LoggerService;
import ru.payments.arm.logger.service.PaymentLogger;
import ru.payments.arm.logger.service.PaymentLoggerFactory;

import java.util.Arrays;

/**
 * Аспект обработки результата выполнения методов ДАО
 */
@Aspect
@Order(10)
@Component
public class DaoLoggingAspect {
    private final PaymentLogger<LogEvent> logger;

    public DaoLoggingAspect(@Qualifier("loggerService") LoggerService loggerService) {
        logger = PaymentLoggerFactory.getLogger(DaoLoggingAspect.class, loggerService);
    }

    @Pointcut("execution(* ru.payments.arm.dao.jdbc..*DaoImpl*.*(..))")
    public void callMethod() {

    }

    @Around("callMethod() && @annotation(logged)")
    public Object call(ProceedingJoinPoint jp, DaoPaymentLogged logged) throws Throwable {
        String parameters = Arrays.toString(jp.getArgs());

        try {
            logger.info(logged.logPoint().getStart(), parameters);
            Object method = jp.proceed();
            logger.info(logged.logPoint().getFinish(), parameters);
            return method;

        } catch (Exception exc) {
            throw new PaymentException(logged.logPoint().getError(), parameters);
        }
    }
}
