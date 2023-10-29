package ru.payments.arm.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Модель данных типа платежа для jdbc.
 */
@AllArgsConstructor
@Getter
public enum PaymentTypeModel {

    TYPE("type"),
    DESCRIPTION("description");

    private final String parameterName;
}
