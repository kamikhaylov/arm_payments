package ru.payments.arm.logging;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для логирования результата выполнения rest-сервиса
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface RestPaymentLogged {

    /** Вызов сервиса */
    PaymentLogEvent start();

    /** Успешное завершение */
    PaymentLogEvent success();

    /** Ошибка в ответе сервиса */
    PaymentLogEvent fail();
}
