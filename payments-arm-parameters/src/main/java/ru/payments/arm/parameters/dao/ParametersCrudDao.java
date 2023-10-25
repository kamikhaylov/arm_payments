package ru.payments.arm.parameters.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.payments.arm.parameters.model.ParameterModel;

/**
 * Crud-методы для работы с таблицей parameters
 */
@Primary
@Repository
public interface ParametersCrudDao extends CrudRepository<ParameterModel, Integer> {

    ParameterModel findByName(String name);
}
