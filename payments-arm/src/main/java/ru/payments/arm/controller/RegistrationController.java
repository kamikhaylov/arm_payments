package ru.payments.arm.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.payments.arm.dto.request.RegistrationRequest;
import ru.payments.arm.dto.response.ArmResponse;
import ru.payments.arm.logging.RestPaymentLogged;
import ru.payments.arm.monitoring.PaymentMonitored;
import ru.payments.arm.service.RegistrationService;
import ru.payments.arm.validation.Validator;

import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0037;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0038;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0039;
import static ru.payments.arm.monitoring.PaymentMonitoringPoint.REGISTRATION_SIGN_UP;

/**
 * Контроллер регистрации
 */
@RestController
@AllArgsConstructor
@RequestMapping("/payments-arm")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final Validator<RegistrationRequest> registrationRequestValidator;

    @PostMapping("/registration/signUp")
    @RestPaymentLogged(start = PAYMENT0037, success = PAYMENT0038, fail = PAYMENT0039)
    @PaymentMonitored(REGISTRATION_SIGN_UP)
    public ResponseEntity<ArmResponse<Void>> registration(@RequestBody RegistrationRequest request) {
        registrationRequestValidator.validateAndThrow(request);
        registrationService.createUser(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
