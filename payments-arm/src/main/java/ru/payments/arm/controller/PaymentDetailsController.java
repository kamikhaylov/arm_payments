package ru.payments.arm.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.payments.arm.dto.request.PaymentDetailsRequest;
import ru.payments.arm.dto.response.ArmResponse;
import ru.payments.arm.dto.response.PaymentDetailsResponse;
import ru.payments.arm.logger.exception.PaymentException;
import ru.payments.arm.logging.RestPaymentLogged;
import ru.payments.arm.monitoring.PaymentMonitored;
import ru.payments.arm.parameters.ParametersService;
import ru.payments.arm.service.PaymentDetailsService;
import ru.payments.arm.validation.Validator;

import javax.annotation.security.RolesAllowed;

import static ru.payments.arm.auth.model.Authorities.VIEW_PAYMENTS;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0004;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0005;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0006;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0018;
import static ru.payments.arm.monitoring.PaymentMonitoringPoint.PAYMENT_DETAILS_FIND;

/**
 * Контроллер для сервиса получения детальной информации платежа клиента
 */
@RestController
@AllArgsConstructor
@RequestMapping("/payments-arm")
public class PaymentDetailsController {

    private final PaymentDetailsService service;
    private final Validator<PaymentDetailsRequest> paymentDetailsRequestValidator;
    private final ParametersService parameters;

    @PostMapping("/payment/details/get")
    @RestPaymentLogged(start = PAYMENT0004, success = PAYMENT0005, fail = PAYMENT0006)
    @PaymentMonitored(PAYMENT_DETAILS_FIND)
    @RolesAllowed(VIEW_PAYMENTS)
    public ResponseEntity<ArmResponse<PaymentDetailsResponse>> getPayment(@RequestBody PaymentDetailsRequest request) {
        if (parameters.isDetailsServiceEnabled()) {
            paymentDetailsRequestValidator.validateAndThrow(request);
            ArmResponse<PaymentDetailsResponse> response = new ArmResponse<>(service.getPaymentDetails(request));
            return new ResponseEntity<>(response, HttpStatus.FOUND);

        } else {
            throw new PaymentException(PAYMENT0018);
        }
    }
}
