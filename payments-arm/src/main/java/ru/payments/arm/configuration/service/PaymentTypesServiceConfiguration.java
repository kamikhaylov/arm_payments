package ru.payments.arm.configuration.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.payments.arm.dao.api.PaymentTypeDao;
import ru.payments.arm.dao.dto.PaymentTypeDaoDto;
import ru.payments.arm.dao.dto.PaymentTypesFindDaoRequest;
import ru.payments.arm.dto.request.PaymentTypesFindRequest;
import ru.payments.arm.dto.response.PaymentTypesFindResponse;
import ru.payments.arm.mapper.Mapper;
import ru.payments.arm.service.PaymentTypesService;

/**
 * Конфигурация сервиса типов платежей
 */
@Configuration
public class PaymentTypesServiceConfiguration {

    @Bean
    public PaymentTypesService paymentTypesService(
            @Qualifier("paymentTypeDao") PaymentTypeDao paymentTypeDao,
            @Qualifier("paymentTypesFindRequestMapper") Mapper<PaymentTypesFindRequest, PaymentTypesFindDaoRequest> paymentTypesFindRequestMapper,
            @Qualifier("paymentTypesFindResponseMapper") Mapper<PaymentTypeDaoDto, PaymentTypesFindResponse> paymentTypesFindResponseMapper) {
        return new PaymentTypesService(
                paymentTypeDao,
                paymentTypesFindRequestMapper,
                paymentTypesFindResponseMapper);
    }
}
