package ru.payments.arm.monitoring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Entity
@Table(name = "monitoring_metrics")
public class MetricModel {

    /** Идентификатор записи */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Дата и время записи */
    private LocalDateTime created;

    /** Код метрики */
    private String code;

    /** Название метрики */
    private String name;

    /** Значение метрики */
    @Column(name = "metric_value")
    private Double value;
}
