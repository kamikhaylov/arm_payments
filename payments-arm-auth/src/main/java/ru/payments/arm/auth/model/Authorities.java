package ru.payments.arm.auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Authorities {

    VIEW_PAYMENTS("view.payments"),
    EDIT_PAYMENTS("edit.payments"),
    VIEW_PAYMENT_TYPES("view.paymentTypes"),
    EDIT_PAYMENT_TYPES("edit.paymentTypes"),
    VIEW_SYSTEM_JOURNAL("view.systemJournal"),
    EDIT_SYSTEM_JOURNAL("edit.systemJournal"),
    VIEW_METRIC_MONITORING("view.metricMonitoring"),
    EDIT_METRIC_MONITORING("edit.metricMonitoring");

    private final String authority;
}
