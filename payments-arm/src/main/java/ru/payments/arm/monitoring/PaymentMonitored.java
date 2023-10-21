package ru.payments.arm.monitoring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация аспекта мониторинга.
 * Оборачивает сервисы событиями и метриками.
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface PaymentMonitored {

    /**
     * Точка мониторинга.
     */
    PaymentMonitoringPoint value();
}
