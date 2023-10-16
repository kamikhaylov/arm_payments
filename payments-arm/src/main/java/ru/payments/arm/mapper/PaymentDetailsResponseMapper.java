package ru.payments.arm.mapper;

import org.modelmapper.ModelMapper;
import ru.payments.arm.dao.dto.PaymentDetailsDaoDto;
import ru.payments.arm.dto.response.PaymentDetailsResponse;

import static java.util.Objects.nonNull;

/**
 * Маппер ответа ДАО в ответ для сервиса получения детальной информации платежа
 */
public class PaymentDetailsResponseMapper implements Mapper<PaymentDetailsDaoDto, PaymentDetailsResponse> {

    private final ModelMapper mapper;

    public PaymentDetailsResponseMapper() {
        this.mapper = new ModelMapper();
        this.mapper.getConfiguration().setSkipNullEnabled(true);
        this.mapper.createTypeMap(PaymentDetailsDaoDto.class, PaymentDetailsResponse.class)
                .addMappings(
                        mapper -> mapper.map(PaymentDetailsDaoDto::getPaymentId, PaymentDetailsResponse::setPaymentId))
                .addMappings(
                        mapper -> mapper.map(PaymentDetailsDaoDto::getClientId, PaymentDetailsResponse::setClientId))
                .addMappings(
                        mapper -> mapper.map(PaymentDetailsDaoDto::getCreationDate, PaymentDetailsResponse::setCreationDate))
                .addMappings(
                        mapper -> mapper.map(PaymentDetailsDaoDto::getAmount, PaymentDetailsResponse::setAmount))
                .addMappings(
                        mapper -> mapper.map(PaymentDetailsDaoDto::getCurrency, PaymentDetailsResponse::setCurrency))
                .addMappings(
                        mapper -> mapper.map(PaymentDetailsDaoDto::getOrganization, PaymentDetailsResponse::setOrganization))
                .addMappings(
                        mapper -> mapper.map(PaymentDetailsDaoDto::getType, PaymentDetailsResponse::setType))
                .addMappings(
                        mapper -> mapper.map(PaymentDetailsDaoDto::getDescription, PaymentDetailsResponse::setDescription));
    }

    @Override
    public PaymentDetailsResponse map(PaymentDetailsDaoDto paymentDetailsDaoDto) {

        return nonNull(paymentDetailsDaoDto)
                       ? this.mapper.map(paymentDetailsDaoDto, PaymentDetailsResponse.class)
                       : null;
    }
}

