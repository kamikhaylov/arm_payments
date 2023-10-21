package ru.payments.arm.dto.request;

import lombok.Data;
import lombok.ToString;

/**
 * Запрос для сервиса получения метрик мониторинга
 */
@Data
@ToString
public class MonitoringRequest {

    /** Дата нижней границы фильтрации */
    private String from;

    /** Дата верхней границы фильтрации */
    private String to;

    /** Код метрики */
    private String code;
}
