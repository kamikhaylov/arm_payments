package ru.payments.arm.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.payments.arm.logger.api.LogEvent;
import ru.payments.arm.logger.service.LoggerService;
import ru.payments.arm.logger.service.PaymentLogger;
import ru.payments.arm.logger.service.PaymentLoggerFactory;

import java.util.Arrays;

/**
 * Аспект обработки результата выполнения сервиса: логирование.
 */
@Aspect
@Order(10)
@Component
public class RestLoggingAspect {
    private final PaymentLogger<LogEvent> logger;

    public RestLoggingAspect(@Qualifier("loggerService") LoggerService loggerService) {
        logger = PaymentLoggerFactory.getLogger(RestLoggingAspect.class, loggerService);
    }

    @Pointcut("execution(public * ru.payments.arm.controller..*Controller*.*(..))")
    public void callService() {

    }

    @Around("callService() && @annotation(logged)")
    public Object call(ProceedingJoinPoint jp, RestPaymentLogged logged) throws Throwable {
        Object response = null;
        String parameters = Arrays.toString(jp.getArgs());
        try {
            logger.info(logged.start(), parameters);
            response = jp.proceed();
            logger.info(logged.success(), response.toString());
        } catch (Exception exc) {
            logger.error(logged.fail(), exc, parameters);
        }
        return response;
    }
}
