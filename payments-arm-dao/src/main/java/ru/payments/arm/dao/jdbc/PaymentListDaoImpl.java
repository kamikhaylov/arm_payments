package ru.payments.arm.dao.jdbc;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.payments.arm.dao.api.PaymentListDao;
import ru.payments.arm.dao.context.PaymentListDaoContext;
import ru.payments.arm.dao.dto.PaymentListDaoDto;
import ru.payments.arm.dao.dto.PaymentListDaoRequest;
import ru.payments.arm.dao.model.PaymentModel;

import java.sql.Types;
import java.util.List;
import java.util.Properties;

@AllArgsConstructor
public class PaymentListDaoImpl implements PaymentListDao {

    private final Properties properties;
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<PaymentListDaoDto> paymentListMapper;

    @Override
    public List<PaymentListDaoDto> getPaymentList(PaymentListDaoContext daoContext) {
        PaymentListDaoRequest daoRequest = daoContext.getRequest();
        MapSqlParameterSource parameterSource =
                new MapSqlParameterSource()
                        .addValue(PaymentModel.PAYMENT_ID.getParameterName(),
                                daoRequest.getPaymentId(), Types.VARCHAR)
                        .addValue(PaymentModel.CLIENT_ID.getParameterName(),
                                daoRequest.getClientId(), Types.VARCHAR)
                        .addValue("from",
                                daoRequest.getFrom(), Types.TIMESTAMP)
                        .addValue("to",
                                daoRequest.getTo(), Types.TIMESTAMP)
                        .addValue("offset",
                                daoRequest.getOffset(), Types.INTEGER)
                        .addValue("pageSize",
                                daoRequest.getPageSize(), Types.INTEGER);

        return jdbcTemplate.query(
                properties.getProperty(Queries.FIND_PAYMENT_LIST.getSqlKey()),
                parameterSource,
                paymentListMapper);
    }
}
