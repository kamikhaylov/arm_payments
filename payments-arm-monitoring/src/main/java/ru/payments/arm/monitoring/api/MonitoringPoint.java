package ru.payments.arm.monitoring.api;

/**
 * Метрики для точки мониторинга.
 */
public interface MonitoringPoint {

    /**
     * Метрика начала операции.
     * @return метрика начала операци
     */
    Metric getStartEvent();

    /**
     * Метрика длительности операции.
     * @return метрика длительности операции
     */
    Metric getDurationEvent();

    /**
     * Метрика успешного завершения операции.
     * @return метрика успешного завершения операции
     */
    Metric getSuccessEvent();

    /**
     * Метрика завершения операции с ошибкой.
     * @return метрика завершения операции с ошибкой
     */
    Metric getErrorEvent();
}
