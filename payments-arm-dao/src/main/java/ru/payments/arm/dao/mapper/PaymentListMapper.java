package ru.payments.arm.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.payments.arm.dao.dto.PaymentListDaoDto;
import ru.payments.arm.dao.model.PaymentModel;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Маппер для списка платежей.
 */
public class PaymentListMapper implements RowMapper<PaymentListDaoDto> {

    @Override
    public PaymentListDaoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        PaymentListDaoDto payment = new PaymentListDaoDto();
        payment.setPaymentId(rs.getString(PaymentModel.PAYMENT_ID.name()));
        payment.setClientId(rs.getString(PaymentModel.CLIENT_ID.name()));
        payment.setCreationDate(rs.getTimestamp(PaymentModel.CREATION_DATE.name()).toLocalDateTime());
        payment.setAmount(rs.getBigDecimal(PaymentModel.AMOUNT.name()));
        payment.setCurrency(rs.getString(PaymentModel.CURRENCY.name()));
        payment.setOrganization(rs.getString(PaymentModel.ORGANIZATION.name()));
        payment.setType(rs.getString(PaymentModel.TYPE.name()));
        payment.setTypeDescription(rs.getString(PaymentModel.TYPE_DESCRIPTION.name()));
        payment.setDescription(rs.getString(PaymentModel.DESCRIPTION.name()));
        return payment;
    }
}
