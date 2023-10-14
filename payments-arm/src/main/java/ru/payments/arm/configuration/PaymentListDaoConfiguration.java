package ru.payments.arm.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.payments.arm.dao.api.PaymentListDao;
import ru.payments.arm.dao.dto.PaymentListDaoDto;
import ru.payments.arm.dao.jdbc.PaymentListDaoImpl;
import ru.payments.arm.dao.mapper.PaymentListMapper;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Конфигурация DAO
 */
@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class PaymentListDaoConfiguration {

    @Bean
    public DataSource dataSource(
            @Value("${jdbc.driver}") String driver,
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.username}") String username,
            @Value("${jdbc.password}") String password) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public PropertiesFactoryBean accidentSqlQueries() {
        PropertiesFactoryBean props = new PropertiesFactoryBean();
        props.setLocation(new ClassPathResource("sql/paymentListSqlQueries.xml"));
        return props;
    }

    @Bean
    public NamedParameterJdbcTemplate paymentsJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public RowMapper<PaymentListDaoDto> paymentListMapper() {
        return new PaymentListMapper();
    }

    @Bean
    public PaymentListDao paymentListDao(
            PropertiesFactoryBean accidentSqlQueries,
            NamedParameterJdbcTemplate paymentsJdbcTemplate,
            RowMapper<PaymentListDaoDto> paymentListMapper) throws IOException {
        return new PaymentListDaoImpl(accidentSqlQueries.getObject(), paymentsJdbcTemplate, paymentListMapper);
    }
}
