package ru.payments.arm.dto.request;

import lombok.Data;

/**
 * Запрос для сервиса удаления типа платежа
 */
@Data
public class DeletePaymentTypeRequest {

    /** Тип платежа */
    private String type;
}
