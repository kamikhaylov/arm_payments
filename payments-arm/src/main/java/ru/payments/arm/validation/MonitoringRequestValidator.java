package ru.payments.arm.validation;

import ru.payments.arm.dto.request.MonitoringRequest;
import ru.payments.arm.logger.api.LogEvent;

import java.util.Objects;

/**
 * Валидатор запроса сервиса получения метрик мониторинга
 */
public class MonitoringRequestValidator extends AbstractValidator<MonitoringRequest> {

    public MonitoringRequestValidator(LogEvent logEvent) {
        super(logEvent);
    }

    @Override
    protected void validate(MonitoringRequest request, ValidatorContainer validatorContainer) {
        checkAndThrowIfFailed(validatorContainer, "request", request, Objects::nonNull);
        checkAndThrowIfFailed(validatorContainer, "code", request.getCode(), Objects::nonNull);
        checkAndThrowIfFailed(validatorContainer, "to", request.getTo(), Objects::nonNull);
        checkAndThrowIfFailed(validatorContainer, "from", request.getFrom(), Objects::nonNull);
    }
}
