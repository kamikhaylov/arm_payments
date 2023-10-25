package ru.payments.arm.parameters;

import lombok.AllArgsConstructor;
import ru.payments.arm.parameters.api.ParametersApi;

import static ru.payments.arm.parameters.Parameters.LIST_SERVICE_ENABLED;

/**
 * Реализация сервиса управления параметрами.
 */
@AllArgsConstructor
public class ParametersServiceImpl implements ParametersService {

    private ParametersApi parametersApi;

    @Override
    public boolean isListServiceEnabled() {
        return parametersApi.getBooleanParameter(LIST_SERVICE_ENABLED.getParameter());
    }
}
