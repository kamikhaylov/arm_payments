package ru.payments.arm.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.payments.arm.dto.request.MonitoringRequest;
import ru.payments.arm.dto.response.MonitoringResponse;
import ru.payments.arm.mapper.Mapper;
import ru.payments.arm.monitoring.model.MetricModel;
import ru.payments.arm.monitoring.service.MonitoringService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class PaymentMonitoringServiceTest {

    @InjectMocks
    private PaymentMonitoringService paymentMonitoringService;
    @Mock
    private MonitoringService monitoringService;
    @Mock
    private Mapper<MetricModel, MonitoringResponse> monitoringResponseMapper;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void after() {
        Mockito.reset(monitoringService, monitoringResponseMapper);
    }

    @Test
    public void testGetMonitoringMetrics() {
        MonitoringRequest request = new MonitoringRequest();
        MetricModel metric = new MetricModel();
        MonitoringResponse monitoringResponse = new MonitoringResponse();
        List<MetricModel> metrics = List.of(metric);
        List<MonitoringResponse> expected = List.of(monitoringResponse);

        when(monitoringService.find()).thenReturn(metrics);
        when(monitoringResponseMapper.map(metric)).thenReturn(monitoringResponse);

        List<MonitoringResponse> actual = paymentMonitoringService.getMonitoringMetrics(request);

        assertNotNull(actual);
        assertEquals(expected, actual);
        verify(monitoringService).find();
        verify(monitoringResponseMapper).map(metric);
        verifyNoMoreInteractions(monitoringService, monitoringResponseMapper);
    }
}