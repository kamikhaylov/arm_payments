package ru.payments.arm.parameters.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Модель управляемого параметра
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "parameters")
public class ParameterModel {

    /** Название параметра */
    @Id
    private String name;

    /** Java-тип параметра */
    @Column(name = "java_type")
    private String javaType;

    /** Описание параметра */
    private String description;

    /** Значение параметра */
    @Column(name = "parameter_value")
    private String value;
}
