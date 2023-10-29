package ru.payments.arm.dto.request;

import lombok.Data;

/**
 * Запрос для сервиса вставки типа платежа
 */
@Data
public class MergePaymentTypeRequest {

    /** Тип платежа */
    private String type;

    /** Описание типа платежа */
    private String description;
}
