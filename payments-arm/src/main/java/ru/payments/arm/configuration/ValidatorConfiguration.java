package ru.payments.arm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.payments.arm.dto.request.DeletePaymentTypeRequest;
import ru.payments.arm.dto.request.MergePaymentTypeRequest;
import ru.payments.arm.dto.request.MonitoringRequest;
import ru.payments.arm.dto.request.PaymentDetailsRequest;
import ru.payments.arm.dto.request.PaymentListRequest;
import ru.payments.arm.dto.request.PaymentTypesFindRequest;
import ru.payments.arm.dto.request.SystemJournalRequest;
import ru.payments.arm.validation.DeletePaymentTypeRequestValidator;
import ru.payments.arm.validation.MergePaymentTypeRequestValidator;
import ru.payments.arm.validation.MonitoringRequestValidator;
import ru.payments.arm.validation.PaymentDetailsRequestValidator;
import ru.payments.arm.validation.PaymentListRequestValidator;
import ru.payments.arm.validation.PaymentTypesFindRequestValidator;
import ru.payments.arm.validation.SystemJournalRequestValidator;
import ru.payments.arm.validation.Validator;

import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0013;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0014;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0015;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0016;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0025;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0030;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0035;

/**
 * Конфигурация валидаторов
 */
@Configuration
public class ValidatorConfiguration {

    @Bean
    public Validator<PaymentDetailsRequest> paymentDetailsRequestValidator() {
        return new PaymentDetailsRequestValidator(PAYMENT0013);
    }

    @Bean
    public Validator<PaymentListRequest> paymentListRequestValidator() {
        return new PaymentListRequestValidator(PAYMENT0014);
    }

    @Bean
    public Validator<MonitoringRequest> monitoringRequestValidator() {
        return new MonitoringRequestValidator(PAYMENT0015);
    }

    @Bean
    public Validator<SystemJournalRequest> systemJournalRequestValidator() {
        return new SystemJournalRequestValidator(PAYMENT0016);
    }

    @Bean
    public Validator<PaymentTypesFindRequest> paymentTypesFindRequestValidator() {
        return new PaymentTypesFindRequestValidator(PAYMENT0025);
    }

    @Bean
    public Validator<MergePaymentTypeRequest> mergePaymentTypeRequestValidator() {
        return new MergePaymentTypeRequestValidator(PAYMENT0030);
    }

    @Bean
    public Validator<DeletePaymentTypeRequest> deletePaymentTypeRequestValidator() {
        return new DeletePaymentTypeRequestValidator(PAYMENT0035);
    }

}
