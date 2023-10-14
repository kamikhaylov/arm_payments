package ru.payments.arm.mapper;

import org.modelmapper.ModelMapper;
import ru.payments.arm.dao.dto.PaymentListDaoDto;
import ru.payments.arm.dto.response.PaymentListResponse;

/**
 * Маппер ответа ДАО в ответ для сервиса получения списка платежей
 */
public class PaymentListResponseMapper implements Mapper<PaymentListDaoDto, PaymentListResponse> {

    private final ModelMapper mapper;

    public PaymentListResponseMapper() {
        this.mapper = new ModelMapper();
        this.mapper.getConfiguration().setSkipNullEnabled(true);
        this.mapper.createTypeMap(PaymentListDaoDto.class, PaymentListResponse.class)
                .addMappings(
                        mapper -> mapper.map(PaymentListDaoDto::getPaymentId, PaymentListResponse::setPaymentId))
                .addMappings(
                        mapper -> mapper.map(PaymentListDaoDto::getClientId, PaymentListResponse::setClientId))
                .addMappings(
                        mapper -> mapper.map(PaymentListDaoDto::getCreationDate, PaymentListResponse::setCreationDate))
                .addMappings(
                        mapper -> mapper.map(PaymentListDaoDto::getAmount, PaymentListResponse::setAmount))
                .addMappings(
                        mapper -> mapper.map(PaymentListDaoDto::getCurrency, PaymentListResponse::setCurrency))
                .addMappings(
                        mapper -> mapper.map(PaymentListDaoDto::getOrganization, PaymentListResponse::setOrganization))
                .addMappings(
                        mapper -> mapper.map(PaymentListDaoDto::getType, PaymentListResponse::setType))
                .addMappings(
                        mapper -> mapper.map(PaymentListDaoDto::getDescription, PaymentListResponse::setDescription));
    }

    @Override
    public PaymentListResponse map(PaymentListDaoDto paymentListDaoDto) {
        return this.mapper.map(paymentListDaoDto, PaymentListResponse.class);
    }
}

