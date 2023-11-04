package ru.payments.arm.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Ответ для сервиса получения метрики мониторинга
 */
@Data
public class MonitoringResponse {

    /** Идентификатор записи */
    private Integer id;

    /** Дата и время записи */
    private LocalDateTime created;

    /** Код метрики */
    private String code;

    /** Название метрики */
    private String name;

    /** Значение метрики */
    private Double value;
}
