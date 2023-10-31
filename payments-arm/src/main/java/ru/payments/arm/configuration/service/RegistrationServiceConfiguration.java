package ru.payments.arm.configuration.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.payments.arm.auth.model.User;
import ru.payments.arm.auth.service.AuthorizationService;
import ru.payments.arm.dto.request.RegistrationRequest;
import ru.payments.arm.mapper.Mapper;
import ru.payments.arm.service.RegistrationService;

/**
 * Конфигурация сервиса регистрации
 */
@Configuration
public class RegistrationServiceConfiguration {

    @Bean
    public RegistrationService registrationService(
            @Qualifier("authorizationService") AuthorizationService authorizationService,
            @Qualifier("registrationRequestMapper") Mapper<RegistrationRequest, User> registrationRequestMapper) {
        return new RegistrationService(authorizationService, registrationRequestMapper);
    }
}
