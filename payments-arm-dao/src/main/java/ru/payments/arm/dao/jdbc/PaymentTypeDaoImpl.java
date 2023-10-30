package ru.payments.arm.dao.jdbc;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.payments.arm.dao.api.PaymentTypeDao;
import ru.payments.arm.dao.dto.PaymentTypeDaoDto;
import ru.payments.arm.dao.dto.PaymentTypesFindDaoRequest;
import ru.payments.arm.dao.logging.DaoPaymentLogged;
import ru.payments.arm.dao.model.PaymentTypeModel;

import javax.transaction.Transactional;
import java.sql.Types;
import java.util.List;
import java.util.Properties;

import static ru.payments.arm.dao.logging.DaoLogPoint.DELETE_PAYMENT_TYPE_DAO_LOG;
import static ru.payments.arm.dao.logging.DaoLogPoint.FIND_PAYMENT_TYPES_DAO_LOG;
import static ru.payments.arm.dao.logging.DaoLogPoint.MERGE_PAYMENT_TYPE_DAO_LOG;

/**
 * Реализация сервиса получения списка типов платежей из БД
 * Таблица payment_types
 */
@AllArgsConstructor
public class PaymentTypeDaoImpl implements PaymentTypeDao {

    private final Properties properties;
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<PaymentTypeDaoDto> paymentTypesMapper;

    @DaoPaymentLogged(logPoint = FIND_PAYMENT_TYPES_DAO_LOG)
    @Override
    public List<PaymentTypeDaoDto> findTypes(PaymentTypesFindDaoRequest daoRequest) {
        MapSqlParameterSource parameterSource =
                new MapSqlParameterSource()
                        .addValue(PaymentTypeModel.TYPE.getParameterName(),
                                getLikeValue(daoRequest.getType()), Types.VARCHAR)
                        .addValue(PaymentTypeModel.DESCRIPTION.getParameterName(),
                                getLikeValue(daoRequest.getDescription()), Types.VARCHAR);

        return jdbcTemplate.query(
                properties.getProperty(Queries.FIND_PAYMENT_TYPE_LIST.getSqlKey()),
                parameterSource,
                paymentTypesMapper);
    }

    @DaoPaymentLogged(logPoint = MERGE_PAYMENT_TYPE_DAO_LOG)
    @Transactional
    @Override
    public void merge(PaymentTypeDaoDto paymentType) {
        MapSqlParameterSource parameterSource =
                new MapSqlParameterSource()
                        .addValue(PaymentTypeModel.TYPE.getParameterName(),
                                paymentType.getType(), Types.VARCHAR)
                        .addValue(PaymentTypeModel.DESCRIPTION.getParameterName(),
                                paymentType.getDescription(), Types.VARCHAR);

        jdbcTemplate.update(
                properties.getProperty(Queries.MERGE_PAYMENT_TYPE.getSqlKey()),
                parameterSource);
    }

    @DaoPaymentLogged(logPoint = DELETE_PAYMENT_TYPE_DAO_LOG)
    @Transactional
    @Override
    public void delete(String type) {
        MapSqlParameterSource parameterSource =
                new MapSqlParameterSource()
                        .addValue(PaymentTypeModel.TYPE.getParameterName(),
                                type, Types.VARCHAR);

        jdbcTemplate.update(
                properties.getProperty(Queries.DELETE_PAYMENT_TYPE.getSqlKey()),
                parameterSource);
    }

    private String getLikeValue(String value) {
        return StringUtils.isNotEmpty(value) ? "%" + value + "%" : null;
    }
}
