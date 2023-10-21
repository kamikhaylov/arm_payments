package ru.payments.arm.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.payments.arm.dto.request.MonitoringRequest;
import ru.payments.arm.dto.response.MonitoringResponse;
import ru.payments.arm.logging.RestPaymentLogged;
import ru.payments.arm.monitoring.PaymentMonitored;
import ru.payments.arm.service.PaymentMonitoringService;

import java.util.List;

import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0010;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0011;
import static ru.payments.arm.logging.PaymentLogEvent.PAYMENT0012;
import static ru.payments.arm.monitoring.PaymentMonitoringPoint.MONITORING_METRICS_FIND;

/**
 * Контроллер для сервиса получения метрик мониторинга
 */
@RestController
@AllArgsConstructor
@RequestMapping("/payments-arm")
public class MonitoringController {

    private PaymentMonitoringService service;

    @PostMapping("/monitoring/metrics/find")
    @RestPaymentLogged(start = PAYMENT0010, success = PAYMENT0011, fail = PAYMENT0012)
    @PaymentMonitored(MONITORING_METRICS_FIND)
    public ResponseEntity<List<MonitoringResponse>> getMonitoringMetrics(@RequestBody MonitoringRequest request) {
        List<MonitoringResponse> response = service.getMonitoringMetrics(request);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
}
