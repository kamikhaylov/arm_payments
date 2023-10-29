package ru.payments.arm.validation;

import lombok.AllArgsConstructor;
import ru.payments.arm.exception.PaymentValidationException;
import ru.payments.arm.logger.api.LogEvent;

import java.util.Arrays;
import java.util.function.Predicate;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Базовый класс валидатора объектов
 */
@AllArgsConstructor
public abstract class AbstractValidator<T> implements Validator<T> {

    protected static final String PAYMENT_ID_REGEX = "^[A-z0-9-]{36}$";
    protected static final String TYPE_REGEX = "^[A-z]{1,50}$";
    protected static final String DESCRIPTION_REGEX = "^[A-zА-яё ]{1,100}$";

    protected static final Predicate<String> CHECK_ID = x -> isNotBlank(x) && x.matches(PAYMENT_ID_REGEX);
    protected static final Predicate<String> CHECK_TYPE = x -> isNotBlank(x) && x.matches(TYPE_REGEX);
    protected static final Predicate<String> CHECK_DESCRIPTION = x -> isNotBlank(x) && x.matches(DESCRIPTION_REGEX);

    private final LogEvent logEvent;

    @Override
    public ValidatorContainer validateAndThrow(T arg) {
        ValidatorContainer validatorContainer = new ValidatorContainer();
        validate(arg, validatorContainer);
        throwIfFailed(validatorContainer, getLogEvent());
        return validatorContainer;
    }

    protected abstract void validate(T arg, ValidatorContainer validatorContainer);

    protected LogEvent getLogEvent() {
        return logEvent;
    }

    protected <V> void checkAndThrowIfFailed(ValidatorContainer validatorContainer, String key,
                                             V value, Predicate<V> predicate) {
        checkAndThrowIfFailed(validatorContainer, getLogEvent(), key, value, predicate);
    }

    protected <V> void checkAndThrowIfFailed(ValidatorContainer validatorContainer, LogEvent logEvent, String key,
                                             V value, Predicate<V> predicate) {
        check(validatorContainer, key, value, predicate);
        throwIfFailed(validatorContainer, logEvent);
    }

    protected <V> boolean check(ValidatorContainer validatorContainer, String key, V value, Predicate<V> predicate) {
        return check(validatorContainer, key, value, predicate.test(value));
    }

    protected <V> boolean check(ValidatorContainer validatorContainer, String key, V value, boolean result) {
        if (!result) {
            validatorContainer.addError(key, value);
        }
        return result;
    }

    protected void throwIfFailed(ValidatorContainer validatorContainer, LogEvent logEvent) {
        if (validatorContainer.hasErrors()) {
            throw new PaymentValidationException(logEvent, Arrays.toString(validatorContainer.getErrors().toArray()));
        }
    }
}
