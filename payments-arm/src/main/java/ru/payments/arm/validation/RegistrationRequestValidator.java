package ru.payments.arm.validation;

import org.apache.commons.lang3.StringUtils;
import ru.payments.arm.dto.request.RegistrationRequest;
import ru.payments.arm.logger.api.LogEvent;

import java.util.Objects;

/**
 * Валидатор запроса регистрации пользователя
 */
public class RegistrationRequestValidator extends AbstractValidator<RegistrationRequest> {

    public RegistrationRequestValidator(LogEvent logEvent) {
        super(logEvent);
    }

    @Override
    protected void validate(RegistrationRequest request, ValidatorContainer validatorContainer) {
        checkAndThrowIfFailed(validatorContainer, "request", request, Objects::nonNull);
        checkAndThrowIfFailed(validatorContainer, "login", request.getLogin(), StringUtils::isNotBlank);
        checkAndThrowIfFailed(validatorContainer, "password", request.getPassword(), StringUtils::isNotBlank);
        checkAndThrowIfFailed(validatorContainer, "email", request.getEmail(), StringUtils::isNotBlank);
    }
}
