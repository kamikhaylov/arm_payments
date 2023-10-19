package ru.payments.arm.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.payments.arm.dto.request.PaymentListRequest;
import ru.payments.arm.dto.response.PaymentListResponse;
import ru.payments.arm.logging.RestPaymentLogged;
import ru.payments.arm.service.PaymentListService;
import ru.payments.arm.service.context.PaymentListContext;

import java.util.List;

import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0001;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0002;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0003;

/**
 * Контроллер для сервиса получения списка платежей клиента
 */
@RestController
@AllArgsConstructor
@RequestMapping("/payments-arm")
public class PaymentListController {

    private PaymentListService service;

    @PostMapping("/payment/list/find")
    @RestPaymentLogged(start = PAYMENT0001, success = PAYMENT0002, fail = PAYMENT0003)
    public ResponseEntity<List<PaymentListResponse>> getPayments(@RequestBody PaymentListRequest request) {
        PaymentListContext context = new PaymentListContext();
        context.setRequest(request);
        List<PaymentListResponse> response = service.getPaymentList(context);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
}
