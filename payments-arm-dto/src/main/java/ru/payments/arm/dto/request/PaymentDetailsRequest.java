package ru.payments.arm.dto.request;

import lombok.Data;
import lombok.ToString;

/**
 * Запрос для сервиса получения списка платежей
 */
@Data
@ToString
public class PaymentDetailsRequest {

    /** Идентификатор платежа */
    private String paymentId;
}
