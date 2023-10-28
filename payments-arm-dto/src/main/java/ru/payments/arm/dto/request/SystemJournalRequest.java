package ru.payments.arm.dto.request;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Запрос для сервиса получения списка записей системного журнала
 */
@Data
public class SystemJournalRequest {

    /** Дата нижней границы фильтрации */
    private String from;

    /** Дата верхней границы фильтрации */
    private String to;

    /** Список уровеней логирования */
    private List<String> level;

    /** Дата и время записи */
    private LocalDateTime created;

    /** Запись журнала */
    private String message;

    /** Параметры логирования */
    private String parameters;

    /** Имя класса */
    private String className;

    /** Трассировка */
    private String trace;
}
