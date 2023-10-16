package ru.payments.arm.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.payments.arm.dto.request.PaymentDetailsRequest;
import ru.payments.arm.dto.request.PaymentListRequest;
import ru.payments.arm.dto.response.PaymentDetailsResponse;
import ru.payments.arm.dto.response.PaymentListResponse;
import ru.payments.arm.service.PaymentDetailsService;
import ru.payments.arm.service.PaymentListService;
import ru.payments.arm.service.context.PaymentListContext;

import java.util.List;

/**
 * Контроллер для сервиса получения детальной информации платежа клиента
 */
@RestController
@AllArgsConstructor
@RequestMapping("/payments-arm")
public class PaymentDetailsController {

    private PaymentDetailsService service;

    @PostMapping("/payment/details/get")
    public ResponseEntity<PaymentDetailsResponse> getPayment(@RequestBody PaymentDetailsRequest request) {
        PaymentDetailsResponse response = service.getPaymentDetails(request);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
}
