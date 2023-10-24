package ru.payments.arm.validation;

import lombok.AllArgsConstructor;
import ru.payments.arm.exception.PaymentValidationException;
import ru.payments.arm.logger.api.LogEvent;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Базовый класс валидатора объектов
 */
@AllArgsConstructor
public abstract class AbstractValidator<T> implements Validator<T> {

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
