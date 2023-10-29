package ru.payments.arm.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.payments.arm.dao.dto.PaymentTypeDaoDto;
import ru.payments.arm.dao.model.PaymentTypeModel;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Маппер для списка типов платежей.
 */
public class PaymentTypesMapper implements RowMapper<PaymentTypeDaoDto> {

    @Override
    public PaymentTypeDaoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        PaymentTypeDaoDto type = new PaymentTypeDaoDto();
        type.setType(rs.getString(PaymentTypeModel.TYPE.name()));
        type.setDescription(rs.getString(PaymentTypeModel.DESCRIPTION.name()));
        return type;
    }
}
