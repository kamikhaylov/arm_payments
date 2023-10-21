package ru.payments.arm.service;

import lombok.AllArgsConstructor;
import ru.payments.arm.dto.request.MonitoringRequest;
import ru.payments.arm.dto.response.MonitoringResponse;
import ru.payments.arm.mapper.Mapper;
import ru.payments.arm.monitoring.model.MetricModel;
import ru.payments.arm.monitoring.service.MonitoringService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис получения метрик мониторинга
 */
@AllArgsConstructor
public class PaymentMonitoringService {

    private MonitoringService monitoringService;
    private Mapper<MetricModel, MonitoringResponse> monitoringResponseMapper;

    /**
     * Возвращает список метрик мониторинга
     *
     * @param request запрос
     * @return список метрик
     */
    public List<MonitoringResponse> getMonitoringMetrics(MonitoringRequest request) {
        List<MetricModel> metrics = monitoringService.find();
        return metrics.stream()
                       .map(monitoringResponseMapper::map)
                       .collect(Collectors.toList());
    }
}
