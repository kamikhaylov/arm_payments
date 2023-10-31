package ru.payments.arm.auth.logging;

import ru.payments.arm.logger.api.LogEvent;

/**
 * События для журналирования.
 */
public enum AuthLogEvent implements LogEvent {

    AUTH0001("Пользователь с данным логином уже зарегистрирован"),
    AUTH0002("Пользователь с данным почтовым ящиком уже зарегистрирован"),
    AUTH0003("Не найдена роль по умолчанию"),
    AUTH0004("Ошибка поиска пользователя по логину"),
    AUTH0005("Ошибка поиска пользователя по почтовому ящику"),
    AUTH0006("Ошибка поиска роли по роли"),
    AUTH0007("Ошибка сохранения пользователя"),
    AUTH0008("Ошибка при создание пользователя");

    private final String title;

    AuthLogEvent(String title) {
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
