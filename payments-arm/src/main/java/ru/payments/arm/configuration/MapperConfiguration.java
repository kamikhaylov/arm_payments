package ru.payments.arm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.payments.arm.dao.context.PaymentListDaoContext;
import ru.payments.arm.dao.dto.PaymentDetailsDaoDto;
import ru.payments.arm.dao.dto.PaymentListDaoDto;
import ru.payments.arm.dao.dto.PaymentTypeDaoDto;
import ru.payments.arm.dao.dto.PaymentTypesFindDaoRequest;
import ru.payments.arm.dto.request.MergePaymentTypeRequest;
import ru.payments.arm.dto.request.PaymentTypesFindRequest;
import ru.payments.arm.dto.response.MonitoringResponse;
import ru.payments.arm.dto.response.PaymentDetailsResponse;
import ru.payments.arm.dto.response.PaymentListResponse;
import ru.payments.arm.dto.response.PaymentTypesFindResponse;
import ru.payments.arm.dto.response.SystemJournalResponse;
import ru.payments.arm.logger.model.LogModel;
import ru.payments.arm.mapper.Mapper;
import ru.payments.arm.mapper.MergePaymentTypeRequestMapper;
import ru.payments.arm.mapper.MonitoringResponseMapper;
import ru.payments.arm.mapper.PaymentDetailsResponseMapper;
import ru.payments.arm.mapper.PaymentListRequestMapper;
import ru.payments.arm.mapper.PaymentListResponseMapper;
import ru.payments.arm.mapper.PaymentTypesFindRequestMapper;
import ru.payments.arm.mapper.PaymentTypesFindResponseMapper;
import ru.payments.arm.mapper.SystemJournalResponseMapper;
import ru.payments.arm.monitoring.model.MetricModel;
import ru.payments.arm.service.context.PaymentListContext;

/**
 * Конфигурация мапперов
 */
@Configuration
public class MapperConfiguration {

    @Bean
    public Mapper<PaymentListContext, PaymentListDaoContext> paymentListRequestMapper() {
        return new PaymentListRequestMapper();
    }

    @Bean
    public Mapper<PaymentListDaoDto, PaymentListResponse> paymentListResponseMapper() {
        return new PaymentListResponseMapper();
    }

    @Bean
    public Mapper<PaymentDetailsDaoDto, PaymentDetailsResponse> paymentDetailsResponseMapper() {
        return new PaymentDetailsResponseMapper();
    }

    @Bean
    public Mapper<LogModel, SystemJournalResponse> systemJournalResponseMapper() {
        return new SystemJournalResponseMapper();
    }

    @Bean
    public Mapper<MetricModel, MonitoringResponse> monitoringResponseMapper() {
        return new MonitoringResponseMapper();
    }

    @Bean
    public Mapper<PaymentTypesFindRequest, PaymentTypesFindDaoRequest> paymentTypesFindRequestMapper() {
        return new PaymentTypesFindRequestMapper();
    }

    @Bean
    public Mapper<PaymentTypeDaoDto, PaymentTypesFindResponse> paymentTypesFindResponseMapper() {
        return new PaymentTypesFindResponseMapper();
    }

    @Bean
    public Mapper<MergePaymentTypeRequest, PaymentTypeDaoDto> mergePaymentTypeRequestMapper() {
        return new MergePaymentTypeRequestMapper();
    }
}
