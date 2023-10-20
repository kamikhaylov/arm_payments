package ru.payments.arm.configuration.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.payments.arm.dto.response.SystemJournalResponse;
import ru.payments.arm.logger.model.LogModel;
import ru.payments.arm.logger.service.LoggerService;
import ru.payments.arm.mapper.Mapper;
import ru.payments.arm.service.SystemJournalService;

/**
 * Конфигурация сервиса получения системного журнала
 */
@Configuration
public class SystemJournalServiceConfiguration {

    @Bean
    public SystemJournalService systemJournalService(
            LoggerService loggerService,
            Mapper<LogModel, SystemJournalResponse> systemJournalResponseMapper) {
        return new SystemJournalService(loggerService, systemJournalResponseMapper);
    }
}
