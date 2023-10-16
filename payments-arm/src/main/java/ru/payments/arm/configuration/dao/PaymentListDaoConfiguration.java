package ru.payments.arm.configuration.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.payments.arm.dao.api.PaymentListDao;
import ru.payments.arm.dao.dto.PaymentListDaoDto;
import ru.payments.arm.dao.jdbc.PaymentListDaoImpl;
import ru.payments.arm.dao.mapper.PaymentListMapper;

import java.io.IOException;

/**
 * Конфигурация DAO сервиса получения списка платежей
 */
@Configuration
public class PaymentListDaoConfiguration {

    @Bean
    public PropertiesFactoryBean paymentListSqlQueries() {
        PropertiesFactoryBean props = new PropertiesFactoryBean();
        props.setLocation(new ClassPathResource("sql/paymentListSqlQueries.xml"));
        return props;
    }

    @Bean
    public RowMapper<PaymentListDaoDto> paymentListMapper() {
        return new PaymentListMapper();
    }

    @Bean
    public PaymentListDao paymentListDao(
            @Qualifier("paymentListSqlQueries") PropertiesFactoryBean paymentListSqlQueries,
            NamedParameterJdbcTemplate paymentsJdbcTemplate,
            RowMapper<PaymentListDaoDto> paymentListMapper) throws IOException {
        return new PaymentListDaoImpl(paymentListSqlQueries.getObject(), paymentsJdbcTemplate, paymentListMapper);
    }
}
