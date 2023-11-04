package ru.payments.arm.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Запрос для сервиса получения метрик мониторинга
 */
@Data
public class MonitoringRequest {

    /** Дата нижней границы фильтрации */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime from;

    /** Дата верхней границы фильтрации */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime to;

    /** Код метрики */
    private String code;
}
