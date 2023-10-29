package ru.payments.arm.dao.dto;

import lombok.Data;

/**
 * Запрос для ДАО сервиса получения типов платежей
 */
@Data
public class PaymentTypesFindDaoRequest {

    /** Тип платежа */
    private String type;

    /** Описание типа платежа */
    private String description;
}
