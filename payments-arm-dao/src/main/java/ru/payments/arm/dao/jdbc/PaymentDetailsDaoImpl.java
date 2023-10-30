package ru.payments.arm.dao.jdbc;

import lombok.AllArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.payments.arm.dao.api.PaymentDetailsDao;
import ru.payments.arm.dao.dto.PaymentDetailsDaoDto;
import ru.payments.arm.dao.logging.DaoPaymentLogged;
import ru.payments.arm.dao.model.PaymentModel;

import java.sql.Types;
import java.util.Properties;

import static ru.payments.arm.dao.logging.DaoLogPoint.GET_PAYMENT_DETAILS_DAO_LOG;

/**
 * Реализация сервиа получения детальной информации платежа из БД
 * Таблица payments
 */
@AllArgsConstructor
public class PaymentDetailsDaoImpl implements PaymentDetailsDao {

    private final Properties properties;
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<PaymentDetailsDaoDto> paymentDetailsMapper;

    @DaoPaymentLogged(logPoint = GET_PAYMENT_DETAILS_DAO_LOG)
    @Override
    public PaymentDetailsDaoDto getById(String paymentId) {
        MapSqlParameterSource parameterSource =
                new MapSqlParameterSource()
                        .addValue(PaymentModel.PAYMENT_ID.getParameterName(),
                                paymentId, Types.VARCHAR);

        return DataAccessUtils.singleResult(jdbcTemplate.query(
                properties.getProperty(Queries.FIND_PAYMENT_DETAILS.getSqlKey()),
                parameterSource,
                paymentDetailsMapper));
    }
}
