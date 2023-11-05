package ru.payments.arm.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.payments.arm.dto.request.SystemJournalRequest;
import ru.payments.arm.dto.response.SystemJournalResponse;
import ru.payments.arm.logger.model.LogModel;
import ru.payments.arm.logger.service.LoggerService;
import ru.payments.arm.mapper.Mapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class SystemJournalServiceTest {

    @InjectMocks
    private SystemJournalService systemJournalService;
    @Mock
    private LoggerService loggerService;
    @Mock
    private Mapper<LogModel, SystemJournalResponse> systemJournalResponseMapper;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void after() {
        Mockito.reset(loggerService, systemJournalResponseMapper);
    }

    @Test
    public void testGetSystemJournal() {
        SystemJournalRequest request = new SystemJournalRequest();
        LogModel log = new LogModel();
        SystemJournalResponse systemJournalResponse = new SystemJournalResponse();
        List<LogModel> logs = List.of(log);
        List<SystemJournalResponse> expected = List.of(systemJournalResponse);

        when(loggerService.findAll()).thenReturn(logs);
        when(systemJournalResponseMapper.map(log)).thenReturn(systemJournalResponse);

        List<SystemJournalResponse> actual = systemJournalService.getSystemJournal(request);

        assertNotNull(actual);
        assertEquals(expected, actual);
        verify(loggerService).findAll();
        verify(systemJournalResponseMapper).map(log);
        verifyNoMoreInteractions(loggerService, systemJournalResponseMapper);
    }
}