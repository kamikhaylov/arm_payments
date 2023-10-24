package ru.payments.arm.validation;

import ru.payments.arm.dto.request.PaymentDetailsRequest;
import ru.payments.arm.logger.api.LogEvent;

import java.util.Objects;
import java.util.function.Predicate;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Валидатор запроса сервиса получения детальной информации платежа
 */
public class PaymentDetailsRequestValidator extends AbstractValidator<PaymentDetailsRequest> {

    private static final String PAYMENT_ID_REGEX = "^[A-z0-9-]{36}$";
    private static final Predicate<String> CHECK_ID = x -> isNotBlank(x) && x.matches(PAYMENT_ID_REGEX);

    public PaymentDetailsRequestValidator(LogEvent logEvent) {
        super(logEvent);
    }

    @Override
    protected void validate(PaymentDetailsRequest request, ValidatorContainer validatorContainer) {
        checkAndThrowIfFailed(validatorContainer, "request", request, Objects::nonNull);
        checkAndThrowIfFailed(validatorContainer, "paymentId", request.getPaymentId(), CHECK_ID);
    }
}
