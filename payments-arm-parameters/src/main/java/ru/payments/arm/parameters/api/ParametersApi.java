package ru.payments.arm.parameters.api;

/**
 * Api сервиса управления параметрами.
 */
public interface ParametersApi {

    /**
     * Получить параметр типа boolean
     *
     * @param name название параметра
     * @return значение параметра
     */
    Boolean getBooleanParameter(String name);

}
