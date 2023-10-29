package ru.payments.arm.validation;

import ru.payments.arm.dto.request.MergePaymentTypeRequest;
import ru.payments.arm.logger.api.LogEvent;

import java.util.Objects;

/**
 * Валидатор запроса сервиса вставки типа платежа
 */
public class MergePaymentTypeRequestValidator extends AbstractValidator<MergePaymentTypeRequest> {

    public MergePaymentTypeRequestValidator(LogEvent logEvent) {
        super(logEvent);
    }

    @Override
    protected void validate(MergePaymentTypeRequest request, ValidatorContainer validatorContainer) {
        checkAndThrowIfFailed(validatorContainer, "request", request, Objects::nonNull);
        checkAndThrowIfFailed(validatorContainer, "type", request.getType(), CHECK_TYPE);
        checkAndThrowIfFailed(validatorContainer, "description", request.getDescription(), CHECK_DESCRIPTION);
    }
}
