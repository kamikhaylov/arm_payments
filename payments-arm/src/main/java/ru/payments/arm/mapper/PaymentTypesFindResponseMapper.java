package ru.payments.arm.mapper;

import org.modelmapper.ModelMapper;
import ru.payments.arm.dao.dto.PaymentTypeDaoDto;
import ru.payments.arm.dto.response.PaymentTypesFindResponse;

/**
 * Маппер ответа ДАО в ответ для сервиса получения списка типов платежей
 */
public class PaymentTypesFindResponseMapper implements Mapper<PaymentTypeDaoDto, PaymentTypesFindResponse> {

    private final ModelMapper mapper;

    public PaymentTypesFindResponseMapper() {
        this.mapper = new ModelMapper();
        this.mapper.getConfiguration().setSkipNullEnabled(true);
        this.mapper.createTypeMap(PaymentTypeDaoDto.class, PaymentTypesFindResponse.class)
                .addMappings(
                        mapper -> mapper.map(PaymentTypeDaoDto::getType, PaymentTypesFindResponse::setType))
                .addMappings(
                        mapper -> mapper.map(PaymentTypeDaoDto::getDescription, PaymentTypesFindResponse::setDescription));
    }

    @Override
    public PaymentTypesFindResponse map(PaymentTypeDaoDto paymentTypeDaoDto) {
        return this.mapper.map(paymentTypeDaoDto, PaymentTypesFindResponse.class);
    }
}
