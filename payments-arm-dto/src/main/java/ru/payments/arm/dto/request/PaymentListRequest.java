package ru.payments.arm.dto.request;

import lombok.Data;
import lombok.ToString;

/**
 * Запрос для сервиса получения списка платежей
 */
@Data
@ToString
public class PaymentListRequest {

    /** Идентификатор платежа */
    private String paymentId;

    /** Идентификатор клиента */
    private String clientId;

    /** Дата нижней границы фильтрации */
    private String from;

    /** Дата верхней границы фильтрации */
    private String to;

    /** Смещение относительно начала выборки */
    private Integer offset;

    /** Количество записей на одной странице */
    private Integer pageSize;
}
