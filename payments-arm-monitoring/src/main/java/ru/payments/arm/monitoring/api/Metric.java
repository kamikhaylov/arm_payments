package ru.payments.arm.monitoring.api;

/**
 * Информация о метрики.
 */
public interface Metric {

    /**
     * Код метрики.
     *
     * @return код события
     */
    String getCode();

    /**
     * Заголовок.
     *
     * @return заголовок метрики
     */
    String getTitle();
}
