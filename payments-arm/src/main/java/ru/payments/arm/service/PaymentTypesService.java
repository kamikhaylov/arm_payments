package ru.payments.arm.service;

import lombok.AllArgsConstructor;
import ru.payments.arm.dao.api.PaymentTypeDao;
import ru.payments.arm.dao.dto.PaymentTypeDaoDto;
import ru.payments.arm.dao.dto.PaymentTypesFindDaoRequest;
import ru.payments.arm.dto.request.PaymentTypesFindRequest;
import ru.payments.arm.dto.response.PaymentTypesFindResponse;
import ru.payments.arm.mapper.Mapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис типов платежей
 */
@AllArgsConstructor
public class PaymentTypesService {

    private final PaymentTypeDao paymentTypeDao;
    private final Mapper<PaymentTypesFindRequest, PaymentTypesFindDaoRequest> paymentTypesFindRequestMapper;
    private final Mapper<PaymentTypeDaoDto, PaymentTypesFindResponse> paymentTypesFindResponseMapper;

    /**
     * Возвращает список типов платежей
     *
     * @param request запрос списка типов
     * @return список типов
     */
    public List<PaymentTypesFindResponse> findTypes(PaymentTypesFindRequest request) {
        PaymentTypesFindDaoRequest daoRequest = paymentTypesFindRequestMapper.map(request);
        List<PaymentTypeDaoDto> types = paymentTypeDao.findTypes(daoRequest);

        return types.stream()
                       .map(paymentTypesFindResponseMapper::map)
                       .collect(Collectors.toList());
    }
}
