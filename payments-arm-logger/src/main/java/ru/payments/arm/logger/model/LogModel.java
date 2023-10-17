package ru.payments.arm.logger.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Модель записи лога
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "system_journal")
public class LogModel {

    /** Идентификатор записи */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Уровень логирования */
    private String level;

    /** Дата и время записи */
    private LocalDateTime created;

    /** Запись журнала */
    private String message;

    /** Параметры логирования */
    private String parameters;

    /** Имя класса */
    @Column(name = "class_name")
    private String className;

    /** Трассировка */
    private String trace;

    public LogModel(int id,
                    String level,
                    LocalDateTime created,
                    String message,
                    String parameters,
                    String className,
                    String trace) {
        this.id = id;
        this.level = level;
        this.created = created;
        this.message = message;
        this.parameters = parameters;
        this.className = className;
        this.trace = trace;
    }

    public LogModel(String level,
                    LocalDateTime created,
                    String message,
                    String parameters,
                    String className,
                    String trace) {
        this.level = level;
        this.created = created;
        this.message = message;
        this.parameters = parameters;
        this.className = className;
        this.trace = trace;
    }

    public LogModel(String level,
                    LocalDateTime created,
                    String message,
                    String parameters,
                    String className) {
        this.level = level;
        this.created = created;
        this.message = message;
        this.parameters = parameters;
        this.className = className;
    }

    public LogModel(String level,
                    LocalDateTime created,
                    String message,
                    String className) {
        this.level = level;
        this.created = created;
        this.message = message;
        this.className = className;
    }
}
