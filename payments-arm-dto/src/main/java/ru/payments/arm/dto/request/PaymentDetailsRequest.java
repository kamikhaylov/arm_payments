package ru.payments.arm.dto.request;

import lombok.Data;

/**
 * Запрос для сервиса получения списка платежей
 */
@Data
public class PaymentDetailsRequest {

    /** Идентификатор платежа */
    private String paymentId;
}
