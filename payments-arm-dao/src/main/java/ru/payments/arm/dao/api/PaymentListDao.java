package ru.payments.arm.dao.api;

import ru.payments.arm.dao.context.PaymentListDaoContext;
import ru.payments.arm.dao.dto.PaymentListDaoDto;

import java.util.List;

/**
 * Сервис получения списка платежей из БД
 * Таблица payments
 */
public interface PaymentListDao {

    /**
     * Получение списка платежей
     *
     * @param daoContext кантекст запроса
     * @return список платежей
     */
    List<PaymentListDaoDto> getPaymentList(PaymentListDaoContext daoContext);
}
