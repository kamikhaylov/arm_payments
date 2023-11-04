package ru.payments.arm.dao.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Запрос для ДАО сервиса получения списка платежей
 */
@Data
public class PaymentListDaoRequest {

    /** Идентификатор платежа */
    private String paymentId;

    /** Идентификатор клиента */
    private String clientId;

    /** Дата нижней границы фильтрации */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime from;

    /** Дата верхней границы фильтрации */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime to;

    /** Смещение относительно начала выборки */
    private Integer offset;

    /** Количество записей на одной странице */
    private Integer pageSize;
}
