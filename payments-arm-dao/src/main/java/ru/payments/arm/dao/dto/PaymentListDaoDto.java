package ru.payments.arm.dao.dto;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Представление данных таблицы payments в DTO.
 */
@Data
@ToString
public class PaymentListDaoDto {

    /** Идентификатор платежа */
    private String paymentId;

    /** Идентификатор клиента */
    private String clientId;

    /** Дата создания */
    private LocalDateTime creationDate;

    /** Сумма платежа */
    private BigDecimal amount;

    /** Валюта платежа */
    private String currency;

    /** Организация */
    private String organization;

    /** Тип платежа */
    private String type;

    /** Описание платежа */
    private String description;
}
