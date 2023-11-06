package ru.payments.arm.parameters;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.payments.arm.parameters.api.ParametersApi;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static ru.payments.arm.parameters.Parameters.DELETE_TYPE_SERVICE_ENABLED;
import static ru.payments.arm.parameters.Parameters.DETAILS_SERVICE_ENABLED;
import static ru.payments.arm.parameters.Parameters.LIST_SERVICE_ENABLED;
import static ru.payments.arm.parameters.Parameters.MERGE_TYPE_SERVICE_ENABLED;
import static ru.payments.arm.parameters.Parameters.MONITORING_SERVICE_ENABLED;
import static ru.payments.arm.parameters.Parameters.SING_UP_SERVICE_ENABLED;
import static ru.payments.arm.parameters.Parameters.SYSTEM_JOURNAL_SERVICE_ENABLED;
import static ru.payments.arm.parameters.Parameters.TYPE_LIST_SERVICE_ENABLED;

class ParametersServiceImplTest {

    @InjectMocks
    private ParametersServiceImpl parametersService;
    @Mock
    private ParametersApi parametersApi;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void after() {
        Mockito.reset(parametersApi);
    }

    @Test
    public void testIsListServiceEnabled() {
        when(parametersApi.getBooleanParameter(LIST_SERVICE_ENABLED.getName())).thenReturn(true);

        boolean actual = parametersService.isListServiceEnabled();

        assertTrue(actual);
        verify(parametersApi).getBooleanParameter(LIST_SERVICE_ENABLED.getName());
        verifyNoMoreInteractions(parametersApi);
    }

    @Test
    public void testIsDetailsServiceEnabled() {
        when(parametersApi.getBooleanParameter(DETAILS_SERVICE_ENABLED.getName())).thenReturn(true);

        boolean actual = parametersService.isDetailsServiceEnabled();

        assertTrue(actual);
        verify(parametersApi).getBooleanParameter(DETAILS_SERVICE_ENABLED.getName());
        verifyNoMoreInteractions(parametersApi);
    }

    @Test
    public void testIsMonitoringServiceEnabled() {
        when(parametersApi.getBooleanParameter(MONITORING_SERVICE_ENABLED.getName())).thenReturn(true);

        boolean actual = parametersService.isMonitoringServiceEnabled();

        assertTrue(actual);
        verify(parametersApi).getBooleanParameter(MONITORING_SERVICE_ENABLED.getName());
        verifyNoMoreInteractions(parametersApi);
    }

    @Test
    public void testIsSystemJournalServiceEnabled() {
        when(parametersApi.getBooleanParameter(SYSTEM_JOURNAL_SERVICE_ENABLED.getName())).thenReturn(true);

        boolean actual = parametersService.isSystemJournalServiceEnabled();

        assertTrue(actual);
        verify(parametersApi).getBooleanParameter(SYSTEM_JOURNAL_SERVICE_ENABLED.getName());
        verifyNoMoreInteractions(parametersApi);
    }

    @Test
    public void testIsTypeListServiceEnabled() {
        when(parametersApi.getBooleanParameter(TYPE_LIST_SERVICE_ENABLED.getName())).thenReturn(true);

        boolean actual = parametersService.isTypeListServiceEnabled();

        assertTrue(actual);
        verify(parametersApi).getBooleanParameter(TYPE_LIST_SERVICE_ENABLED.getName());
        verifyNoMoreInteractions(parametersApi);
    }

    @Test
    public void testIsMergeTypeServiceEnabled() {
        when(parametersApi.getBooleanParameter(MERGE_TYPE_SERVICE_ENABLED.getName())).thenReturn(true);

        boolean actual = parametersService.isMergeTypeServiceEnabled();

        assertTrue(actual);
        verify(parametersApi).getBooleanParameter(MERGE_TYPE_SERVICE_ENABLED.getName());
        verifyNoMoreInteractions(parametersApi);
    }

    @Test
    public void testIsDeleteTypeServiceEnabled() {
        when(parametersApi.getBooleanParameter(DELETE_TYPE_SERVICE_ENABLED.getName())).thenReturn(true);

        boolean actual = parametersService.isDeleteTypeServiceEnabled();

        assertTrue(actual);
        verify(parametersApi).getBooleanParameter(DELETE_TYPE_SERVICE_ENABLED.getName());
        verifyNoMoreInteractions(parametersApi);
    }

    @Test
    public void testIsSingUpServiceEnabled() {
        when(parametersApi.getBooleanParameter(SING_UP_SERVICE_ENABLED.getName())).thenReturn(true);

        boolean actual = parametersService.isSingUpServiceEnabled();

        assertTrue(actual);
        verify(parametersApi).getBooleanParameter(SING_UP_SERVICE_ENABLED.getName());
        verifyNoMoreInteractions(parametersApi);
    }
}