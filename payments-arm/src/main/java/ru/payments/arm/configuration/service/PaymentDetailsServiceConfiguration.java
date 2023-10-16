package ru.payments.arm.configuration.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.payments.arm.dao.api.PaymentDetailsDao;
import ru.payments.arm.dao.dto.PaymentDetailsDaoDto;
import ru.payments.arm.dto.response.PaymentDetailsResponse;
import ru.payments.arm.mapper.Mapper;
import ru.payments.arm.service.PaymentDetailsService;

/**
 * Конфигурация сервиса получения детальной информации платежа
 */
@Configuration
public class PaymentDetailsServiceConfiguration {

    @Bean
    public PaymentDetailsService paymentDetailsService(
            @Qualifier("paymentDetailsDao") PaymentDetailsDao paymentDetailsDao,
            @Qualifier("paymentDetailsResponseMapper")
            Mapper<PaymentDetailsDaoDto, PaymentDetailsResponse> paymentDetailsResponseMapper) {
        return new PaymentDetailsService(
                paymentDetailsDao,
                paymentDetailsResponseMapper);
    }
}
