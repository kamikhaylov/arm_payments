package ru.payments.arm.dao.jdbc;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.payments.arm.dao.api.PaymentTypeDao;
import ru.payments.arm.dao.dto.PaymentTypeDaoDto;
import ru.payments.arm.dao.dto.PaymentTypesFindDaoRequest;
import ru.payments.arm.dao.model.PaymentTypeModel;

import java.sql.Types;
import java.util.List;
import java.util.Properties;

/**
 * Реализация сервиса получения списка типов платежей из БД
 * Таблица payment_types
 */
@AllArgsConstructor
public class PaymentTypeDaoImpl implements PaymentTypeDao {

    private final Properties properties;
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<PaymentTypeDaoDto> paymentTypesMapper;

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

    private String getLikeValue(String value) {
        return StringUtils.isNotEmpty(value) ? "%" + value + "%" : null;
    }
}
