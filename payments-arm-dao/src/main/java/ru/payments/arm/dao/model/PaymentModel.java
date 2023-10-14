package ru.payments.arm.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Модель данных платежа для jdbc.
 */
@AllArgsConstructor
@Getter
public enum PaymentModel {

    PAYMENT_ID("paymentId"),
    CLIENT_ID("clientId"),
    CREATION_DATE("creationDate"),
    AMOUNT("amount"),
    CURRENCY("currency"),
    ORGANIZATION("organization"),
    TYPE("type"),
    DESCRIPTION("description");

    private final String parameterName;
}
