package ru.payments.arm.service;

import lombok.AllArgsConstructor;
import ru.payments.arm.dao.api.PaymentListDao;
import ru.payments.arm.dao.context.PaymentListDaoContext;
import ru.payments.arm.dao.dto.PaymentListDaoDto;
import ru.payments.arm.dto.response.PaymentListResponse;
import ru.payments.arm.exception.PaymentException;
import ru.payments.arm.mapper.Mapper;
import ru.payments.arm.parameters.ParametersService;
import ru.payments.arm.service.context.PaymentListContext;

import java.util.List;
import java.util.stream.Collectors;

import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0017;

/**
 * Сервис получения списка платежей
 */
@AllArgsConstructor
public class PaymentListService {

    private final PaymentListDao paymentListDao;
    private final Mapper<PaymentListContext, PaymentListDaoContext> paymentListRequestMapper;
    private final Mapper<PaymentListDaoDto, PaymentListResponse> paymentListResponseMapper;
    private final ParametersService parameters;

    /**
     * Возвращает список платежей
     * @param context контекст запроса
     * @return список платежей
     */
    public List<PaymentListResponse> getPaymentList(PaymentListContext context) {

        if (parameters.isListServiceEnabled()) {
            PaymentListDaoContext daoContext = paymentListRequestMapper.map(context);
            List<PaymentListDaoDto> payments = paymentListDao.getPaymentList(daoContext);

            return payments.stream()
                           .map(paymentListResponseMapper::map)
                           .collect(Collectors.toList());
        } else {
            throw new PaymentException(PAYMENT0017);
        }
    }
}
