package ru.payments.arm.dao.dto;

import lombok.Data;

/**
 * Представление данных таблицы payment_types в DTO для типа платежа.
 */
@Data
public class PaymentTypeDaoDto {

    /** Тип платежа */
    private String type;

    /** Описание типа платежа */
    private String description;
}
