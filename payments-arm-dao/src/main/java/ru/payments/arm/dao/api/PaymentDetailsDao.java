package ru.payments.arm.dao.api;

import ru.payments.arm.dao.dto.PaymentDetailsDaoDto;

/**
 * Сервис получения детальной информации платежа из БД
 * Таблица payments
 */
public interface PaymentDetailsDao {

    /**
     * Получение детальной информации платежа
     *
     * @param paymentId идентификатор платежа
     * @return платеж
     */
    PaymentDetailsDaoDto getById(String paymentId);
}
