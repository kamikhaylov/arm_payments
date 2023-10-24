package ru.payments.arm.validation;

import java.util.ArrayList;
import java.util.List;

/**
 * Контейнер с ошибками валидации
 */
public class ValidatorContainer {
    private final List<String> errors = new ArrayList<>();

    public void addError(String key, Object value) {
        if (!errors.contains(key)) {
            errors.add(key + ": " + value.toString());
        }
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<String> getErrors() {
        return errors;
    }
}
