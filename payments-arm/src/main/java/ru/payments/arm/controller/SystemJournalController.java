package ru.payments.arm.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.payments.arm.dto.request.SystemJournalRequest;
import ru.payments.arm.dto.response.ArmResponse;
import ru.payments.arm.dto.response.SystemJournalResponse;
import ru.payments.arm.exception.PaymentException;
import ru.payments.arm.logging.RestPaymentLogged;
import ru.payments.arm.monitoring.PaymentMonitored;
import ru.payments.arm.parameters.ParametersService;
import ru.payments.arm.service.SystemJournalService;
import ru.payments.arm.validation.Validator;

import java.util.List;

import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0007;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0008;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0009;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0020;
import static ru.payments.arm.monitoring.PaymentMonitoringPoint.SYSTEM_JOURNAL_FIND;

/**
 * Контроллер для сервиса получения записей системного журнала
 */
@RestController
@AllArgsConstructor
@RequestMapping("/payments-arm")
public class SystemJournalController {

    private final SystemJournalService service;
    private final Validator<SystemJournalRequest> systemJournalRequestValidator;
    private final ParametersService parameters;

    @PostMapping("/logger/systemJournal/find")
    @RestPaymentLogged(start = PAYMENT0007, success = PAYMENT0008, fail = PAYMENT0009)
    @PaymentMonitored(SYSTEM_JOURNAL_FIND)
    public ResponseEntity<ArmResponse<List<SystemJournalResponse>>> getSystemJournal(@RequestBody SystemJournalRequest request) {
        if (parameters.isSystemJournalServiceEnabled()) {
            systemJournalRequestValidator.validateAndThrow(request);
            ArmResponse<List<SystemJournalResponse>> response = new ArmResponse<>(service.getSystemJournal(request));
            return new ResponseEntity<>(response, HttpStatus.FOUND);

        } else {
            throw new PaymentException(PAYMENT0020);
        }
    }
}
