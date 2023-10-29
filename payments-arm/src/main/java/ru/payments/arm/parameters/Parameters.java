package ru.payments.arm.parameters;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Управляемые параметры.
 */
@AllArgsConstructor
@Getter
public enum Parameters {

    LIST_SERVICE_ENABLED("payment.list.service.enabled"),
    DETAILS_SERVICE_ENABLED("payment.details.service.enabled"),
    MONITORING_SERVICE_ENABLED("payment.monitoring.service.enabled"),
    SYSTEM_JOURNAL_SERVICE_ENABLED("payment.systemJournal.service.enabled"),
    TYPE_LIST_SERVICE_ENABLED("payment.type.list.service.enabled");

    private final String name;
}
