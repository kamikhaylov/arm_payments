package ru.payments.arm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.payments.arm.dto.request.PaymentDetailsRequest;
import ru.payments.arm.validation.PaymentDetailsRequestValidator;
import ru.payments.arm.validation.Validator;

import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0013;

/**
 * Конфигурация валидаторов
 */
@Configuration
public class ValidatorConfiguration {

    @Bean
    public Validator<PaymentDetailsRequest> paymentDetailsRequestValidator() {
        return new PaymentDetailsRequestValidator(PAYMENT0013);
    }

}
