package ru.payments.arm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.payments.arm.parameters.ParametersService;
import ru.payments.arm.parameters.ParametersServiceImpl;
import ru.payments.arm.parameters.api.ParametersApi;

/**
 * Конфигурация сервисов управления параметрами
 */
@Configuration
public class ParametersServiceConfiguration {

    @Bean
    public ParametersService parameterService(ParametersApi parametersApi) {
        return new ParametersServiceImpl(parametersApi);
    }
}
