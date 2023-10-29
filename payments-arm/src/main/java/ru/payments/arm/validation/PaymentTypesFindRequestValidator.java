package ru.payments.arm.validation;

import org.apache.commons.lang3.StringUtils;
import ru.payments.arm.dto.request.PaymentTypesFindRequest;
import ru.payments.arm.logger.api.LogEvent;

import java.util.Objects;
import java.util.function.Predicate;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class PaymentTypesFindRequestValidator extends AbstractValidator<PaymentTypesFindRequest> {

    protected static final String TYPE_REGEX = "^[A-z]{1,50}$";
    protected static final String DESCRIPTION_REGEX = "^[A-zА-яё ]{1,100}$";
    protected static final Predicate<String> CHECK_TYPE = x -> isNotBlank(x) && x.matches(TYPE_REGEX);
    protected static final Predicate<String> CHECK_DESCRIPTION = x -> isNotBlank(x) && x.matches(DESCRIPTION_REGEX);

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
