package ru.payments.arm.service.context;

import lombok.Data;

/**
 * Контекст для сервисов
 * @param <T> тип запроса
 */
@Data
public class PaymentContext<T> {

    /** Запрос */
    private T request;
}
