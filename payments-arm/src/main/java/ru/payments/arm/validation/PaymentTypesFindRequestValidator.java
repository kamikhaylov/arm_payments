package ru.payments.arm.validation;

import org.apache.commons.lang3.StringUtils;
import ru.payments.arm.dto.request.PaymentTypesFindRequest;
import ru.payments.arm.logger.api.LogEvent;

import java.util.Objects;

/**
 * Валидатор запроса сервиса получения списка типов платежей
 */
public class PaymentTypesFindRequestValidator extends AbstractValidator<PaymentTypesFindRequest> {

    public PaymentTypesFindRequestValidator(LogEvent logEvent) {
        super(logEvent);
    }

    @Override
    protected void validate(PaymentTypesFindRequest request, ValidatorContainer validatorContainer) {

        checkAndThrowIfFailed(validatorContainer, "request", request, Objects::nonNull);
        if (StringUtils.isNotBlank(request.getType())) {
            checkAndThrowIfFailed(validatorContainer, "type", request.getType(), CHECK_TYPE);
        }
        if (StringUtils.isNotBlank(request.getDescription())) {
            checkAndThrowIfFailed(validatorContainer, "description", request.getDescription(), CHECK_DESCRIPTION);
        }
    }
}
