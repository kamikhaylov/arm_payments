package ru.payments.arm.parameters.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.payments.arm.parameters.exception.ParameterException;
import ru.payments.arm.parameters.api.ParametersApi;
import ru.payments.arm.parameters.dao.ParametersDao;
import ru.payments.arm.parameters.model.ParameterModel;

import static java.util.Objects.nonNull;
import static ru.payments.arm.parameters.logging.ParameterLogEvent.PAYMENT_PARAMETER_0001;
import static ru.payments.arm.parameters.service.JavaType.BOOLEAN_TYPE;

/**
 * Сервис управления параметрами
 */
@Service
@AllArgsConstructor
public class ParametersApiImpl implements ParametersApi {

    private ParametersDao parametersDao;

    @Override
    public Boolean getBooleanParameter(String name) {

        ParameterModel parameter = parametersDao.findByName(name);
        if (nonNull(parameter) && parameter.getJavaType().equals(BOOLEAN_TYPE.getJavaType())) {
            return Boolean.parseBoolean(parameter.getValue());
        } else {
            throw new ParameterException(PAYMENT_PARAMETER_0001, name);
        }
    }
}
