package ru.payments.arm.monitoring.logging;

import ru.payments.arm.logger.api.LogEvent;

/**
 * События для журналирования.
 */
public enum MonitoringLogEvent implements LogEvent {

    MON0001("Ошибка при сохранение метрики мониторинга в таблице в monitoring_metrics"),
    MON0002("Ошибка при поиске метрики мониториинга в таблице в monitoring_metrics");

    private final String title;

    MonitoringLogEvent(String title) {
        this.title = title;
    }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return getCode() + ". " + getTitle();
    }
}
