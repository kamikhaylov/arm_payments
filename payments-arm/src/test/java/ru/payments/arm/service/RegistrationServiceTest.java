package ru.payments.arm.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.payments.arm.auth.model.User;
import ru.payments.arm.auth.service.AuthorizationService;
import ru.payments.arm.dto.request.RegistrationRequest;
import ru.payments.arm.mapper.Mapper;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class RegistrationServiceTest {

    @InjectMocks
    private RegistrationService registrationService;

    @Mock
    private AuthorizationService authorizationService;
    @Mock
    private Mapper<RegistrationRequest, User> registrationRequestMapper;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void after() {
        Mockito.reset(authorizationService, registrationRequestMapper);
    }

    @Test
    public void testCreateUser() {
        RegistrationRequest request = new RegistrationRequest();
        User user = new User();
        when(registrationRequestMapper.map(request)).thenReturn(user);

        registrationService.createUser(request);

        verify(registrationRequestMapper).map(request);
        verify(authorizationService).createUser(user);
        verifyNoMoreInteractions(authorizationService, registrationRequestMapper);
    }
}