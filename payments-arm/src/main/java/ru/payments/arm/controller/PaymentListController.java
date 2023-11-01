package ru.payments.arm.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.payments.arm.dto.request.PaymentListRequest;
import ru.payments.arm.dto.response.ArmResponse;
import ru.payments.arm.dto.response.PaymentListResponse;
import ru.payments.arm.logger.exception.PaymentException;
import ru.payments.arm.logging.RestPaymentLogged;
import ru.payments.arm.monitoring.PaymentMonitored;
import ru.payments.arm.parameters.ParametersService;
import ru.payments.arm.service.PaymentListService;
import ru.payments.arm.service.context.PaymentListContext;
import ru.payments.arm.validation.Validator;

import java.util.List;

import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0001;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0002;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0003;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0017;
import static ru.payments.arm.monitoring.PaymentMonitoringPoint.PAYMENT_LIST_FIND;

/**
 * Контроллер для сервиса получения списка платежей клиента
 */
@RestController
@AllArgsConstructor
@RequestMapping("/payments-arm")
public class PaymentListController {

    private final PaymentListService service;
    private final Validator<PaymentListRequest> paymentListRequestValidator;
    private final ParametersService parameters;

    @PostMapping("/payment/list/find")
    @RestPaymentLogged(start = PAYMENT0001, success = PAYMENT0002, fail = PAYMENT0003)
    @PaymentMonitored(PAYMENT_LIST_FIND)
    public ResponseEntity<ArmResponse<List<PaymentListResponse>>> getPayments(@RequestBody PaymentListRequest request) {
        if (parameters.isListServiceEnabled()) {
            paymentListRequestValidator.validateAndThrow(request);
            PaymentListContext context = new PaymentListContext();
            context.setRequest(request);
            ArmResponse<List<PaymentListResponse>> response = new ArmResponse<>(service.getPaymentList(context));
            return new ResponseEntity<>(response, HttpStatus.FOUND);

        } else {
            throw new PaymentException(PAYMENT0017);
        }
    }
}
