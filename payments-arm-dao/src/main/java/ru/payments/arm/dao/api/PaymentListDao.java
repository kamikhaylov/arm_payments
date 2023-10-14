package ru.payments.arm.dao.api;

import ru.payments.arm.dao.context.PaymentListDaoContext;
import ru.payments.arm.dao.dto.PaymentListDaoDto;

import java.util.List;

public interface PaymentListDao {

    List<PaymentListDaoDto> getPaymentList(PaymentListDaoContext daoContext);

}
