package ru.payments.arm.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.payments.arm.dto.request.DeletePaymentTypeRequest;
import ru.payments.arm.dto.request.MergePaymentTypeRequest;
import ru.payments.arm.dto.request.PaymentTypesFindRequest;
import ru.payments.arm.dto.response.ArmResponse;
import ru.payments.arm.dto.response.PaymentTypesFindResponse;
import ru.payments.arm.exception.PaymentException;
import ru.payments.arm.logging.RestPaymentLogged;
import ru.payments.arm.monitoring.PaymentMonitored;
import ru.payments.arm.parameters.ParametersService;
import ru.payments.arm.service.PaymentTypesService;
import ru.payments.arm.validation.Validator;

import java.util.List;

import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0021;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0022;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0023;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0024;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0026;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0027;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0028;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0029;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0031;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0032;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0033;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0034;
import static ru.payments.arm.monitoring.PaymentMonitoringPoint.PAYMENT_DELETE_TYPE;
import static ru.payments.arm.monitoring.PaymentMonitoringPoint.PAYMENT_MERGE_TYPE;
import static ru.payments.arm.monitoring.PaymentMonitoringPoint.PAYMENT_TYPE_LIST_FIND;

/**
 * Контроллер типов платежей
 */
@RestController
@AllArgsConstructor
@RequestMapping("/payments-arm")
public class PaymentTypesController {

    private final PaymentTypesService service;
    private final Validator<PaymentTypesFindRequest> paymentTypesFindRequestValidator;
    private final Validator<MergePaymentTypeRequest> mergePaymentTypeRequestValidator;
    private final Validator<DeletePaymentTypeRequest> deletePaymentTypeRequestValidator;
    private final ParametersService parameters;

    @PostMapping("/payment/types/find")
    @RestPaymentLogged(start = PAYMENT0021, success = PAYMENT0022, fail = PAYMENT0023)
    @PaymentMonitored(PAYMENT_TYPE_LIST_FIND)
    public ResponseEntity<ArmResponse<List<PaymentTypesFindResponse>>> findTypes(@RequestBody PaymentTypesFindRequest request) {
        if (parameters.isTypeListServiceEnabled()) {
            paymentTypesFindRequestValidator.validateAndThrow(request);
            ArmResponse<List<PaymentTypesFindResponse>> response = new ArmResponse<>(service.findTypes(request));
            return new ResponseEntity<>(response, HttpStatus.FOUND);

        } else {
            throw new PaymentException(PAYMENT0024);
        }
    }

    @PostMapping("/payment/type/merge")
    @RestPaymentLogged(start = PAYMENT0026, success = PAYMENT0027, fail = PAYMENT0028)
    @PaymentMonitored(PAYMENT_MERGE_TYPE)
    public ResponseEntity<Void> mergeType(@RequestBody MergePaymentTypeRequest request) {
        if (parameters.isMergeTypeServiceEnabled()) {
            mergePaymentTypeRequestValidator.validateAndThrow(request);
            service.mergeType(request);
            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            throw new PaymentException(PAYMENT0029);
        }
    }

    @PostMapping("/payment/type/delete")
    @RestPaymentLogged(start = PAYMENT0031, success = PAYMENT0032, fail = PAYMENT0033)
    @PaymentMonitored(PAYMENT_DELETE_TYPE)
    public ResponseEntity<Void> mergeType(@RequestBody DeletePaymentTypeRequest request) {
        if (parameters.isDeleteTypeServiceEnabled()) {
            deletePaymentTypeRequestValidator.validateAndThrow(request);
            service.deleteType(request);
            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            throw new PaymentException(PAYMENT0034);
        }
    }
}
