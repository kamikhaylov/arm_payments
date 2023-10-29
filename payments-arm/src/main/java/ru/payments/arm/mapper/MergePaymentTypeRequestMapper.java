package ru.payments.arm.mapper;

import org.modelmapper.ModelMapper;
import ru.payments.arm.dao.dto.PaymentTypeDaoDto;
import ru.payments.arm.dto.request.MergePaymentTypeRequest;

/**
 * Маппер запроса сервиса вставки типа платежа в ДАО ДТО
 */
public class MergePaymentTypeRequestMapper implements Mapper<MergePaymentTypeRequest, PaymentTypeDaoDto> {

    private final ModelMapper mapper;

    public MergePaymentTypeRequestMapper() {
        this.mapper = new ModelMapper();
        this.mapper.getConfiguration().setSkipNullEnabled(true);
        this.mapper.createTypeMap(MergePaymentTypeRequest.class, PaymentTypeDaoDto.class);
    }

    @Override
    public PaymentTypeDaoDto map(MergePaymentTypeRequest request) {
        return this.mapper.map(request, PaymentTypeDaoDto.class);
    }
}
