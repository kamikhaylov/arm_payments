package ru.payments.arm.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Запрос для сервиса получения списка записей системного журнала
 */
@Data
public class SystemJournalRequest {

    /** Дата нижней границы фильтрации */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime from;

    /** Дата верхней границы фильтрации */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime to;

    /** Список уровеней логирования */
    private List<String> level;

    /** Запись журнала */
    private String message;

    /** Параметры логирования */
    private String parameters;

    /** Имя класса */
    private String className;

    /** Трассировка */
    private String trace;
}
