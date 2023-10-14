package ru.payments.arm.dao.context;

import lombok.Data;

/**
 * ДАО контекст для сервисов
 * @param <T> тип запроса
 */
@Data
public class PaymentDaoContext<T> {

    /** Запрос */
    private T request;
}
