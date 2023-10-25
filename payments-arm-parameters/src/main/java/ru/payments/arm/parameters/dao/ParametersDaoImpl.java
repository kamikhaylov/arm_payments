package ru.payments.arm.parameters.dao;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.payments.arm.parameters.model.ParameterModel;

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
        return parametersCrudDao.findByName(name);
    }
}
