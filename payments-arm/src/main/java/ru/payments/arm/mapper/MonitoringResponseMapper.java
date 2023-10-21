package ru.payments.arm.mapper;

import org.modelmapper.ModelMapper;
import ru.payments.arm.dto.response.MonitoringResponse;
import ru.payments.arm.monitoring.model.MetricModel;

/**
 * Маппер ответа ДАО в ответ для сервиса получения метрик мониторинга
 */
public class MonitoringResponseMapper implements Mapper<MetricModel, MonitoringResponse> {

    private final ModelMapper mapper;

    public MonitoringResponseMapper() {
        this.mapper = new ModelMapper();
        this.mapper.getConfiguration().setSkipNullEnabled(true);
    }

    @Override
    public MonitoringResponse map(MetricModel metric) {
        return this.mapper.map(metric, MonitoringResponse.class);
    }
}
