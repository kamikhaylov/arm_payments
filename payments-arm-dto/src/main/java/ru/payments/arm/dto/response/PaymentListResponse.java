package ru.payments.arm.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Ответ для сервиса получения списка платежей
 */
@Data
public class PaymentListResponse {

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

    /** Описание типа платежа */
    private String typeDescription;

    /** Описание платежа */
    private String description;
}