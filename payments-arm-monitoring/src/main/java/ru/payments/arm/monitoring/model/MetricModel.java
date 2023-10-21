package ru.payments.arm.monitoring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
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
 * Модель метрики мониторинга
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "monitoring_metrics")
public class MetricModel {

    /** Идентификатор записи */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Дата и время записи */
    private LocalDateTime created;

    /** Код метрики */
    private String code;

    /** Название метрики */
    private String name;

    /** Значение метрики */
    @Column(name = "metric_value")
    private double value;
}
