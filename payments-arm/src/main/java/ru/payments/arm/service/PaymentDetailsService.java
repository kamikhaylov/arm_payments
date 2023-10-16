package ru.payments.arm.service;

import lombok.AllArgsConstructor;
import ru.payments.arm.dao.api.PaymentDetailsDao;
import ru.payments.arm.dao.dto.PaymentDetailsDaoDto;
import ru.payments.arm.dto.request.PaymentDetailsRequest;
import ru.payments.arm.dto.response.PaymentDetailsResponse;
import ru.payments.arm.mapper.Mapper;

/**
 * Сервис получения детальной информации платежа
 */
@AllArgsConstructor
public class PaymentDetailsService {

    private final PaymentDetailsDao paymentDetailsDao;
    private final Mapper<PaymentDetailsDaoDto, PaymentDetailsResponse> paymentDetailsResponseMapper;

    /**
     * Возвращает платеж
     * @param request запроса
     * @return платеж
     */
    public PaymentDetailsResponse getPaymentDetails(PaymentDetailsRequest request) {
        PaymentDetailsDaoDto payment = paymentDetailsDao.getById(request.getPaymentId());
        return paymentDetailsResponseMapper.map(payment);
    }
}
