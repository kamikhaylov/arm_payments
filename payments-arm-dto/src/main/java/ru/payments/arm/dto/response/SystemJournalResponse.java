package ru.payments.arm.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Ответ для сервиса получения списка записей системного журнала
 */
@Data
public class SystemJournalResponse {

    /** Идентификатор записи */
    private Integer id;

    /** Уровень логирования */
    private String level;

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
