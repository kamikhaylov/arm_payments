package ru.payments.arm.validation;

import ru.payments.arm.dto.request.DeletePaymentTypeRequest;
import ru.payments.arm.logger.api.LogEvent;

import java.util.Objects;

/**
 * Валидатор запроса сервиса удаления типа платежа
 */
public class DeletePaymentTypeRequestValidator extends AbstractValidator<DeletePaymentTypeRequest> {

    public DeletePaymentTypeRequestValidator(LogEvent logEvent) {
        super(logEvent);
    }

    @Override
    protected void validate(DeletePaymentTypeRequest request, ValidatorContainer validatorContainer) {
        checkAndThrowIfFailed(validatorContainer, "request", request, Objects::nonNull);
        checkAndThrowIfFailed(validatorContainer, "type", request.getType(), CHECK_TYPE);
    }
}
