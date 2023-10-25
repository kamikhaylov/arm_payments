package ru.payments.arm.parameters.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.payments.arm.parameters.model.ParameterModel;

/**
 * Интерфейс взаимодействия с таблицей parameters
 */
@Primary
@Repository
public interface ParametersDao {

    ParameterModel findByName(String name);
}
