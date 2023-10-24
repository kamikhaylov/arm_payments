package ru.payments.arm.validation;

/**
 * Интерфейс валидатора объектов
 */
public interface Validator<T> {

    /**
     * Проверяет объект и выбрасывает исключение
     * @param arg валидируемый объект типа T
     * @return контейнер с ошибками
     */
    ValidatorContainer validateAndThrow(T arg);
}
