package ru.payments.arm.auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Authorities {

    public static final String VIEW_PAYMENTS = "view.payments";
    public static final String EDIT_PAYMENTS = "edit.payments";
    public static final String VIEW_PAYMENT_TYPES = "view.paymentTypes";
    public static final String EDIT_PAYMENT_TYPES = "edit.paymentTypes";
    public static final String VIEW_SYSTEM_JOURNAL = "view.systemJournal";
    public static final String EDIT_SYSTEM_JOURNAL = "edit.systemJournal";
    public static final String VIEW_METRIC_MONITORING = "view.metricMonitoring";
    public static final String EDIT_METRIC_MONITORING = "edit.metricMonitoring";

}
