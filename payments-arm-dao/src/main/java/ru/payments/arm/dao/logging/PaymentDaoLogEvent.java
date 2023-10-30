package ru.payments.arm.dao.logging;

import ru.payments.arm.logger.api.LogEvent;

/**
 * События для журналирования.
 */
public enum PaymentDaoLogEvent implements LogEvent {

    DAO0001("Получение списка платежей из таблицы payments"),
    DAO0002("Завершено получение списка платежей из таблицы payments"),
    DAO0003("Ошибка получения списка платежей из таблицы payments"),
    DAO0004("Получение детальной информации платежа из таблицы payments"),
    DAO0005("Завершено получение детальной информации платежа из таблицы payments"),
    DAO0006("Ошибка получения детальной информации платежа из таблицы payments"),
    DAO0007("Получение типа платежа из таблицы payment_types"),
    DAO0008("Завершено получение типа платежа из таблицы payment_types"),
    DAO0009("Ошибка получения типа платежа из таблицы payment_types"),
    DAO0010("Вставка типа платежа в таблицу payment_types"),
    DAO0011("Завершена вставка типа платежа в таблицу payment_types"),
    DAO0012("Ошибка вставки типа платежа в таблицу payment_types"),
    DAO0013("Удаление типа платежа в таблицу payment_types"),
    DAO0014("Завершено удаление типа платежа в таблицу payment_types"),
    DAO0015("Ошибка удаления типа платежа в таблицу payment_types");

    private final String title;

    PaymentDaoLogEvent(String title) {
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
