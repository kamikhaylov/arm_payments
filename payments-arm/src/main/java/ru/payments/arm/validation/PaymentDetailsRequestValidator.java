package ru.payments.arm.validation;

import ru.payments.arm.dto.request.PaymentDetailsRequest;
import ru.payments.arm.logger.api.LogEvent;

import java.util.Objects;

/**
 * Валидатор запроса сервиса получения детальной информации платежа
 */
public class PaymentDetailsRequestValidator extends AbstractValidator<PaymentDetailsRequest> {

    public PaymentDetailsRequestValidator(LogEvent logEvent) {
        super(logEvent);
    }

    @Override
    protected void validate(PaymentDetailsRequest request, ValidatorContainer validatorContainer) {
        checkAndThrowIfFailed(validatorContainer, "request", request, Objects::nonNull);
        checkAndThrowIfFailed(validatorContainer, "paymentId", request.getPaymentId(), CHECK_ID);
    }
}
