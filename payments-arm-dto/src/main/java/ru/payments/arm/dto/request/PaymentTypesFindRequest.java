package ru.payments.arm.dto.request;

import lombok.Data;

/**
 * Запрос для сервиса получения типов платежей
 */
@Data
public class PaymentTypesFindRequest {

    /** Тип платежа */
    private String type;

    /** Описание типа платежа */
    private String description;
}
