package ru.payments.arm.monitoring;

import lombok.AllArgsConstructor;
import ru.payments.arm.monitoring.api.Metric;
import ru.payments.arm.monitoring.api.MonitoringPoint;

import static ru.payments.arm.monitoring.PaymentMetric.MONITORING_METRICS_FIND_DURATION;
import static ru.payments.arm.monitoring.PaymentMetric.MONITORING_METRICS_FIND_ERROR;
import static ru.payments.arm.monitoring.PaymentMetric.MONITORING_METRICS_FIND_REQUEST;
import static ru.payments.arm.monitoring.PaymentMetric.MONITORING_METRICS_FIND_SUCCESS;
import static ru.payments.arm.monitoring.PaymentMetric.PAYMENT_DELETE_TYPE_DURATION;
import static ru.payments.arm.monitoring.PaymentMetric.PAYMENT_DELETE_TYPE_ERROR;
import static ru.payments.arm.monitoring.PaymentMetric.PAYMENT_DELETE_TYPE_REQUEST;
import static ru.payments.arm.monitoring.PaymentMetric.PAYMENT_DELETE_TYPE_SUCCESS;
import static ru.payments.arm.monitoring.PaymentMetric.PAYMENT_DETAILS_FIND_DURATION;
import static ru.payments.arm.monitoring.PaymentMetric.PAYMENT_DETAILS_FIND_ERROR;
import static ru.payments.arm.monitoring.PaymentMetric.PAYMENT_DETAILS_FIND_REQUEST;
import static ru.payments.arm.monitoring.PaymentMetric.PAYMENT_DETAILS_FIND_SUCCESS;
import static ru.payments.arm.monitoring.PaymentMetric.PAYMENT_LIST_FIND_DURATION;
import static ru.payments.arm.monitoring.PaymentMetric.PAYMENT_LIST_FIND_ERROR;
import static ru.payments.arm.monitoring.PaymentMetric.PAYMENT_LIST_FIND_REQUEST;
import static ru.payments.arm.monitoring.PaymentMetric.PAYMENT_LIST_FIND_SUCCESS;
import static ru.payments.arm.monitoring.PaymentMetric.PAYMENT_MERGE_TYPE_DURATION;
import static ru.payments.arm.monitoring.PaymentMetric.PAYMENT_MERGE_TYPE_ERROR;
import static ru.payments.arm.monitoring.PaymentMetric.PAYMENT_MERGE_TYPE_REQUEST;
import static ru.payments.arm.monitoring.PaymentMetric.PAYMENT_MERGE_TYPE_SUCCESS;
import static ru.payments.arm.monitoring.PaymentMetric.PAYMENT_TYPE_LIST_FIND_DURATION;
import static ru.payments.arm.monitoring.PaymentMetric.PAYMENT_TYPE_LIST_FIND_ERROR;
import static ru.payments.arm.monitoring.PaymentMetric.PAYMENT_TYPE_LIST_FIND_REQUEST;
import static ru.payments.arm.monitoring.PaymentMetric.PAYMENT_TYPE_LIST_FIND_SUCCESS;
import static ru.payments.arm.monitoring.PaymentMetric.REGISTRATION_SIGN_UP_DURATION;
import static ru.payments.arm.monitoring.PaymentMetric.REGISTRATION_SIGN_UP_ERROR;
import static ru.payments.arm.monitoring.PaymentMetric.REGISTRATION_SIGN_UP_REQUEST;
import static ru.payments.arm.monitoring.PaymentMetric.REGISTRATION_SIGN_UP_SUCCESS;
import static ru.payments.arm.monitoring.PaymentMetric.SYSTEM_JOURNAL_FIND_DURATION;
import static ru.payments.arm.monitoring.PaymentMetric.SYSTEM_JOURNAL_FIND_ERROR;
import static ru.payments.arm.monitoring.PaymentMetric.SYSTEM_JOURNAL_FIND_REQUEST;
import static ru.payments.arm.monitoring.PaymentMetric.SYSTEM_JOURNAL_FIND_SUCCESS;

/**
 * Точки мониторинга
 */
@AllArgsConstructor
public enum PaymentMonitoringPoint implements MonitoringPoint {

    PAYMENT_LIST_FIND(
            PAYMENT_LIST_FIND_REQUEST,
            PAYMENT_LIST_FIND_DURATION,
            PAYMENT_LIST_FIND_SUCCESS,
            PAYMENT_LIST_FIND_ERROR),
    PAYMENT_DETAILS_FIND(
            PAYMENT_DETAILS_FIND_REQUEST,
            PAYMENT_DETAILS_FIND_DURATION,
            PAYMENT_DETAILS_FIND_SUCCESS,
            PAYMENT_DETAILS_FIND_ERROR),
    SYSTEM_JOURNAL_FIND(
            SYSTEM_JOURNAL_FIND_REQUEST,
            SYSTEM_JOURNAL_FIND_DURATION,
            SYSTEM_JOURNAL_FIND_SUCCESS,
            SYSTEM_JOURNAL_FIND_ERROR),
    MONITORING_METRICS_FIND(
            MONITORING_METRICS_FIND_REQUEST,
            MONITORING_METRICS_FIND_DURATION,
            MONITORING_METRICS_FIND_SUCCESS,
            MONITORING_METRICS_FIND_ERROR),
    PAYMENT_TYPE_LIST_FIND(
            PAYMENT_TYPE_LIST_FIND_REQUEST,
            PAYMENT_TYPE_LIST_FIND_DURATION,
            PAYMENT_TYPE_LIST_FIND_SUCCESS,
            PAYMENT_TYPE_LIST_FIND_ERROR),
    PAYMENT_MERGE_TYPE(
            PAYMENT_MERGE_TYPE_REQUEST,
            PAYMENT_MERGE_TYPE_DURATION,
            PAYMENT_MERGE_TYPE_SUCCESS,
            PAYMENT_MERGE_TYPE_ERROR),
    PAYMENT_DELETE_TYPE(
            PAYMENT_DELETE_TYPE_REQUEST,
            PAYMENT_DELETE_TYPE_DURATION,
            PAYMENT_DELETE_TYPE_SUCCESS,
            PAYMENT_DELETE_TYPE_ERROR),
    REGISTRATION_SIGN_UP(
            REGISTRATION_SIGN_UP_REQUEST,
            REGISTRATION_SIGN_UP_DURATION,
            REGISTRATION_SIGN_UP_SUCCESS,
            REGISTRATION_SIGN_UP_ERROR);

    private final Metric startEvent;
    private final Metric durationEvent;
    private final Metric successEvent;
    private final Metric errorEvent;

    @Override
    public Metric getStartEvent() {
        return startEvent;
    }

    @Override
    public Metric getDurationEvent() {
        return durationEvent;
    }

    @Override
    public Metric getSuccessEvent() {
        return successEvent;
    }

    @Override
    public Metric getErrorEvent() {
        return errorEvent;
    }
}