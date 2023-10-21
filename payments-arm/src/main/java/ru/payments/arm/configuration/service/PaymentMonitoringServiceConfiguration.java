package ru.payments.arm.configuration.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.payments.arm.dto.response.MonitoringResponse;
import ru.payments.arm.mapper.Mapper;
import ru.payments.arm.monitoring.model.MetricModel;
import ru.payments.arm.monitoring.service.MonitoringService;
import ru.payments.arm.service.PaymentMonitoringService;

/**
 * Конфигурация сервиса мониторинга
 */
@Configuration
public class PaymentMonitoringServiceConfiguration {

    @Bean
    public PaymentMonitoringService paymentMonitoringService(
            MonitoringService monitoringService,
            Mapper<MetricModel, MonitoringResponse> monitoringResponseMapper) {
        return new PaymentMonitoringService(monitoringService, monitoringResponseMapper);
    }
}
