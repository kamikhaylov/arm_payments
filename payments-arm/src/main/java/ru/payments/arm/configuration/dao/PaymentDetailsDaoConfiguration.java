package ru.payments.arm.configuration.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.payments.arm.dao.api.PaymentDetailsDao;
import ru.payments.arm.dao.dto.PaymentDetailsDaoDto;
import ru.payments.arm.dao.jdbc.PaymentDetailsDaoImpl;
import ru.payments.arm.dao.mapper.PaymentDetailsMapper;

import java.io.IOException;

/**
 * Конфигурация DAO сервиса получения детальной информации платежа
 */
@Configuration
public class PaymentDetailsDaoConfiguration {

    @Bean
    public PropertiesFactoryBean paymentDetailsSqlQueries() {
        PropertiesFactoryBean props = new PropertiesFactoryBean();
        props.setLocation(new ClassPathResource("sql/paymentDetailsSqlQueries.xml"));
        return props;
    }

    @Bean
    public RowMapper<PaymentDetailsDaoDto> paymentDetailsMapper() {
        return new PaymentDetailsMapper();
    }

    @Bean
    public PaymentDetailsDao paymentDetailsDao(
            @Qualifier("paymentDetailsSqlQueries") PropertiesFactoryBean paymentDetailsSqlQueries,
            NamedParameterJdbcTemplate paymentsJdbcTemplate,
            RowMapper<PaymentDetailsDaoDto> paymentDetailsMapper) throws IOException {
        return new PaymentDetailsDaoImpl(paymentDetailsSqlQueries.getObject(), paymentsJdbcTemplate, paymentDetailsMapper);
    }
}
