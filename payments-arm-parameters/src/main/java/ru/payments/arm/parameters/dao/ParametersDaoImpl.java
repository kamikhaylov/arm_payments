package ru.payments.arm.parameters.dao;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.payments.arm.logger.exception.PaymentException;
import ru.payments.arm.parameters.model.ParameterModel;

import static ru.payments.arm.parameters.logging.ParameterLogEvent.PAYMENT_PARAMETER_0002;

/**
 * Реализация взаимодействия с таблицей parameters
 */
@Primary
@Repository
@AllArgsConstructor
public class ParametersDaoImpl implements ParametersDao {

    private ParametersCrudDao parametersCrudDao;

    @Override
    public ParameterModel findByName(String name) {
        try {
            return parametersCrudDao.findByName(name);
        } catch (Exception exc) {
            throw new PaymentException(PAYMENT_PARAMETER_0002, name);
        }
    }
}
