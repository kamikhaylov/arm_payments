package ru.payments.arm.dao.jdbc;

import lombok.AllArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.payments.arm.dao.api.PaymentDetailsDao;
import ru.payments.arm.dao.api.PaymentListDao;
import ru.payments.arm.dao.context.PaymentListDaoContext;
import ru.payments.arm.dao.dto.PaymentDetailsDaoDto;
import ru.payments.arm.dao.dto.PaymentListDaoDto;
import ru.payments.arm.dao.dto.PaymentListDaoRequest;
import ru.payments.arm.dao.model.PaymentModel;

import java.sql.Types;
import java.util.List;
import java.util.Properties;

/**
 * Реализация сервиа получения детальной информации платежа из БД
 * Таблица payments
 */
@AllArgsConstructor
public class PaymentDetailsDaoImpl implements PaymentDetailsDao {

    private final Properties properties;
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<PaymentDetailsDaoDto> paymentDetailsMapper;

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
