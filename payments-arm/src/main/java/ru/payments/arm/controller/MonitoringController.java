package ru.payments.arm.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.payments.arm.dto.request.MonitoringRequest;
import ru.payments.arm.dto.response.ArmResponse;
import ru.payments.arm.dto.response.MonitoringResponse;
import ru.payments.arm.logger.exception.PaymentException;
import ru.payments.arm.logging.RestPaymentLogged;
import ru.payments.arm.monitoring.PaymentMonitored;
import ru.payments.arm.parameters.ParametersService;
import ru.payments.arm.service.PaymentMonitoringService;
import ru.payments.arm.validation.Validator;

import javax.annotation.security.RolesAllowed;
import java.util.List;

import static ru.payments.arm.auth.model.Authorities.VIEW_METRIC_MONITORING;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0010;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0011;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0012;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0019;
import static ru.payments.arm.monitoring.PaymentMonitoringPoint.MONITORING_METRICS_FIND;

/**
 * Контроллер для сервиса получения метрик мониторинга
 */
@RestController
@AllArgsConstructor
@RequestMapping("/payments-arm")
public class MonitoringController {

    private final PaymentMonitoringService service;
    private final Validator<MonitoringRequest> monitoringRequestValidator;
    private final ParametersService parameters;

    @PostMapping("/monitoring/metrics/find")
    @RestPaymentLogged(start = PAYMENT0010, success = PAYMENT0011, fail = PAYMENT0012)
    @PaymentMonitored(MONITORING_METRICS_FIND)
    @RolesAllowed(VIEW_METRIC_MONITORING)
    public ResponseEntity<ArmResponse<List<MonitoringResponse>>> getMonitoringMetrics(@RequestBody MonitoringRequest request) {
        if (parameters.isMonitoringServiceEnabled()) {
            monitoringRequestValidator.validateAndThrow(request);
            ArmResponse<List<MonitoringResponse>> response = new ArmResponse<>(service.getMonitoringMetrics(request));
            return new ResponseEntity<>(response, HttpStatus.FOUND);

        } else {
            throw new PaymentException(PAYMENT0019);
        }
    }
}
