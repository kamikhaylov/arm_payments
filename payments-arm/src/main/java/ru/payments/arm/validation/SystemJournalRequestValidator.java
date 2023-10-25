package ru.payments.arm.validation;

import ru.payments.arm.dto.request.SystemJournalRequest;
import ru.payments.arm.logger.api.LogEvent;

import java.util.Objects;

/**
 * Валидатор запроса сервиса получения записей системного журнала
 */
public class SystemJournalRequestValidator extends AbstractValidator<SystemJournalRequest> {

    public SystemJournalRequestValidator(LogEvent logEvent) {
        super(logEvent);
    }

    @Override
    protected void validate(SystemJournalRequest request, ValidatorContainer validatorContainer) {
        checkAndThrowIfFailed(validatorContainer, "request", request, Objects::nonNull);
        checkAndThrowIfFailed(validatorContainer, "to", request.getTo(), Objects::nonNull);
        checkAndThrowIfFailed(validatorContainer, "from", request.getFrom(), Objects::nonNull);
    }
}
