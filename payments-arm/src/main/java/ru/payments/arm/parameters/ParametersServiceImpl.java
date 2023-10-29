package ru.payments.arm.parameters;

import lombok.AllArgsConstructor;
import ru.payments.arm.parameters.api.ParametersApi;

import static ru.payments.arm.parameters.Parameters.DELETE_TYPE_SERVICE_ENABLED;
import static ru.payments.arm.parameters.Parameters.DETAILS_SERVICE_ENABLED;
import static ru.payments.arm.parameters.Parameters.LIST_SERVICE_ENABLED;
import static ru.payments.arm.parameters.Parameters.MERGE_TYPE_SERVICE_ENABLED;
import static ru.payments.arm.parameters.Parameters.MONITORING_SERVICE_ENABLED;
import static ru.payments.arm.parameters.Parameters.SYSTEM_JOURNAL_SERVICE_ENABLED;
import static ru.payments.arm.parameters.Parameters.TYPE_LIST_SERVICE_ENABLED;

/**
 * Реализация сервиса управления параметрами.
 */
@AllArgsConstructor
public class ParametersServiceImpl implements ParametersService {

    private ParametersApi parametersApi;

    @Override
    public boolean isListServiceEnabled() {
        return parametersApi.getBooleanParameter(LIST_SERVICE_ENABLED.getName());
    }

    @Override
    public boolean isDetailsServiceEnabled() {
        return parametersApi.getBooleanParameter(DETAILS_SERVICE_ENABLED.getName());
    }

    @Override
    public boolean isMonitoringServiceEnabled() {
        return parametersApi.getBooleanParameter(MONITORING_SERVICE_ENABLED.getName());
    }

    @Override
    public boolean isSystemJournalServiceEnabled() {
        return parametersApi.getBooleanParameter(SYSTEM_JOURNAL_SERVICE_ENABLED.getName());
    }

    @Override
    public boolean isTypeListServiceEnabled() {
        return parametersApi.getBooleanParameter(TYPE_LIST_SERVICE_ENABLED.getName());
    }

    @Override
    public boolean isMergeTypeServiceEnabled() {
        return parametersApi.getBooleanParameter(MERGE_TYPE_SERVICE_ENABLED.getName());
    }

    @Override
    public boolean isDeleteTypeServiceEnabled() {
        return parametersApi.getBooleanParameter(DELETE_TYPE_SERVICE_ENABLED.getName());
    }
}
