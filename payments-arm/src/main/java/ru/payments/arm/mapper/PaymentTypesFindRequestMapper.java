package ru.payments.arm.mapper;

import org.modelmapper.ModelMapper;
import ru.payments.arm.dao.dto.PaymentTypesFindDaoRequest;
import ru.payments.arm.dto.request.PaymentTypesFindRequest;

/**
 * Маппер запроса сервиса получения списка типов платежей в ДАО запрос
 */
public class PaymentTypesFindRequestMapper implements Mapper<PaymentTypesFindRequest, PaymentTypesFindDaoRequest> {

    private final ModelMapper mapper;

    public PaymentTypesFindRequestMapper() {
        this.mapper = new ModelMapper();
        this.mapper.getConfiguration().setSkipNullEnabled(true);
        this.mapper.createTypeMap(PaymentTypesFindRequest.class, PaymentTypesFindDaoRequest.class);
    }

    @Override
    public PaymentTypesFindDaoRequest map(PaymentTypesFindRequest request) {
        return this.mapper.map(request, PaymentTypesFindDaoRequest.class);
    }
}
