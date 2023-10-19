package ru.payments.arm.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.payments.arm.dto.request.PaymentDetailsRequest;
import ru.payments.arm.dto.response.PaymentDetailsResponse;
import ru.payments.arm.logging.RestPaymentLogged;
import ru.payments.arm.service.PaymentDetailsService;

import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0004;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0005;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0006;

/**
 * Контроллер для сервиса получения детальной информации платежа клиента
 */
@RestController
@AllArgsConstructor
@RequestMapping("/payments-arm")
public class PaymentDetailsController {

    private PaymentDetailsService service;

    @PostMapping("/payment/details/get")
    @RestPaymentLogged(start = PAYMENT0004, success = PAYMENT0005, fail = PAYMENT0006)
    public ResponseEntity<PaymentDetailsResponse> getPayment(@RequestBody PaymentDetailsRequest request) {
        PaymentDetailsResponse response = service.getPaymentDetails(request);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
}
