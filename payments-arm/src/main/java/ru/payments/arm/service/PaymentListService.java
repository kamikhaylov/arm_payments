package ru.payments.arm.service;

import lombok.AllArgsConstructor;
import ru.payments.arm.dao.api.PaymentListDao;
import ru.payments.arm.dao.context.PaymentListDaoContext;
import ru.payments.arm.dao.dto.PaymentListDaoDto;
import ru.payments.arm.dto.response.PaymentListResponse;
import ru.payments.arm.mapper.Mapper;
import ru.payments.arm.service.context.PaymentListContext;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис получения списка платежей
 */
@AllArgsConstructor
public class PaymentListService {

    private final PaymentListDao paymentListDao;
    private final Mapper<PaymentListContext, PaymentListDaoContext> paymentListRequestMapper;
    private final Mapper<PaymentListDaoDto, PaymentListResponse> paymentListResponseMapper;

    /**
     * Возвращает список платежей
     * @param context контекст запроса
     * @return список платежей
     */
    public List<PaymentListResponse> getPaymentList(PaymentListContext context) {

        PaymentListDaoContext daoContext = paymentListRequestMapper.map(context);
        List<PaymentListDaoDto> payments = paymentListDao.getPaymentList(daoContext);

        return payments.stream()
                       .map(paymentListResponseMapper::map)
                       .collect(Collectors.toList());
    }
}
