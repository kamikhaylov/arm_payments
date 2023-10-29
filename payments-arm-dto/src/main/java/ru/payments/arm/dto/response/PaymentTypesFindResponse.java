package ru.payments.arm.dto.response;

import lombok.Data;

/**
 * Ответ для сервиса получения типов платежей
 */
@Data
public class PaymentTypesFindResponse {

    /** Тип платежа */
    private String type;

    /** Описание типа платежа */
    private String description;
}
