package ru.payments.arm.configuration.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.payments.arm.dao.api.PaymentTypeDao;
import ru.payments.arm.dao.dto.PaymentTypeDaoDto;
import ru.payments.arm.dao.jdbc.PaymentTypeDaoImpl;
import ru.payments.arm.dao.mapper.PaymentTypesMapper;

import java.io.IOException;

/**
 * Конфигурация DAO сервиса получения списка типов платежей
 */
@Configuration
public class PaymentTypeDaoConfiguration {

    @Bean
    public PropertiesFactoryBean paymentTypesSqlQueries() {
        PropertiesFactoryBean props = new PropertiesFactoryBean();
        props.setLocation(new ClassPathResource("sql/paymentTypesSqlQueries.xml"));
        return props;
    }

    @Bean
    public RowMapper<PaymentTypeDaoDto> paymentTypesMapper() {
        return new PaymentTypesMapper();
    }

    @Bean
    public PaymentTypeDao paymentTypeDao(
            @Qualifier("paymentTypesSqlQueries") PropertiesFactoryBean paymentTypesSqlQueries,
            NamedParameterJdbcTemplate paymentsJdbcTemplate,
            RowMapper<PaymentTypeDaoDto> paymentTypesMapper) throws IOException {
        return new PaymentTypeDaoImpl(
                paymentTypesSqlQueries.getObject(),
                paymentsJdbcTemplate,
                paymentTypesMapper);
    }
}
