package ru.payments.arm.dao.api;

import ru.payments.arm.dao.dto.PaymentTypeDaoDto;
import ru.payments.arm.dao.dto.PaymentTypesFindDaoRequest;

import java.util.List;

/**
 * Сервис получения списка типов платежей из БД
 * Таблица payment_types
 */
public interface PaymentTypeDao {

    /**
     * Получение списка  типов платежей
     *
     * @param daoRequest запрос
     * @return список типов
     */
    List<PaymentTypeDaoDto> findTypes(PaymentTypesFindDaoRequest daoRequest);

}
