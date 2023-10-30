package ru.payments.arm.dao.logging;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для логировани выполнения методов ДАО
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface DaoPaymentLogged {

    /** Точка события */
    DaoLogPoint logPoint();
}
