package ru.payments.arm.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.payments.arm.dao.api.PaymentListDao;
import ru.payments.arm.dao.context.PaymentListDaoContext;
import ru.payments.arm.dao.dto.PaymentListDaoDto;
import ru.payments.arm.dto.response.PaymentListResponse;
import ru.payments.arm.mapper.Mapper;
import ru.payments.arm.service.PaymentListService;
import ru.payments.arm.service.context.PaymentListContext;

/**
 * Конфигурация сервисов
 */
@Configuration
public class ServiceConfiguration {

    @Bean
    public PaymentListService paymentListService(
            @Qualifier("paymentListDao") PaymentListDao paymentListDao,
            @Qualifier("paymentListRequestMapper") Mapper<PaymentListContext, PaymentListDaoContext> paymentListRequestMapper,
            @Qualifier("paymentListResponseMapper") Mapper<PaymentListDaoDto, PaymentListResponse> paymentListResponseMapper) {
        return new PaymentListService(
                paymentListDao,
                paymentListRequestMapper,
                paymentListResponseMapper);
    }
}
