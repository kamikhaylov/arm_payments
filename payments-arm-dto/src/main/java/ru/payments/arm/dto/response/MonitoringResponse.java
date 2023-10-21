package ru.payments.arm.dto.response;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Ответ для сервиса получения метрики мониторинга
 */
@Data
@ToString
public class MonitoringResponse {

    /** Идентификатор записи */
    private int id;

    /** Дата и время записи */
    private LocalDateTime created;

    /** Код метрики */
    private String code;

    /** Название метрики */
    private String name;

    /** Значение метрики */
    private double value;
}
