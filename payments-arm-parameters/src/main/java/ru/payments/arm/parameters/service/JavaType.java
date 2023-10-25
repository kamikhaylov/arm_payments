package ru.payments.arm.parameters.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Перечень java-типов для управляемых параметров
 */
@AllArgsConstructor
@Getter
public enum JavaType {

    BOOLEAN_TYPE("java.lang.Boolean");

    private final String javaType;
}
