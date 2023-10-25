package ru.payments.arm.parameters;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Управляемые параметры.
 */
@AllArgsConstructor
@Getter
public enum Parameters {

    LIST_SERVICE_ENABLED("payment.list.service.enabled");

    private final String parameter;
}
