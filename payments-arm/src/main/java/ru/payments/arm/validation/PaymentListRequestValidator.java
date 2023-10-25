package ru.payments.arm.validation;

import org.apache.commons.lang3.StringUtils;
import ru.payments.arm.dto.request.PaymentListRequest;
import ru.payments.arm.logger.api.LogEvent;

import java.util.Objects;

/**
 * Валидатор запроса сервиса получения списка платежей
 */
public class PaymentListRequestValidator extends AbstractValidator<PaymentListRequest> {

    public PaymentListRequestValidator(LogEvent logEvent) {
        super(logEvent);
    }

    @Override
    protected void validate(PaymentListRequest request, ValidatorContainer validatorContainer) {
        checkAndThrowIfFailed(validatorContainer, "request", request, Objects::nonNull);
        checkAndThrowIfFailed(validatorContainer, "offset", request.getOffset(), Objects::nonNull);
        checkAndThrowIfFailed(validatorContainer, "pageSize", request.getPageSize(), Objects::nonNull);
        if (StringUtils.isNotBlank(request.getPaymentId())) {
            checkAndThrowIfFailed(validatorContainer, "paymentId", request.getPaymentId(), CHECK_ID);
        }
    }
}
