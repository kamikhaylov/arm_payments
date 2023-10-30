package ru.payments.arm.logger.logging;

import ru.payments.arm.logger.api.LogEvent;

/**
 * События для журналирования.
 */
public enum LoggerLogEvent implements LogEvent {

    LOG0001("Ошибка при сохранение лога в таблице в system_journal"),
    LOG0002("Ошибка при поиске лога в таблице в system_journal");

    private final String title;

    LoggerLogEvent(String title) {
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
