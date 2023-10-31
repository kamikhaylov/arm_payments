package ru.payments.arm.service;

import lombok.AllArgsConstructor;
import ru.payments.arm.auth.model.User;
import ru.payments.arm.auth.service.AuthorizationService;
import ru.payments.arm.dto.request.RegistrationRequest;
import ru.payments.arm.mapper.Mapper;

/**
 * Сервис регистрации
 */
@AllArgsConstructor
public class RegistrationService {

    private AuthorizationService authorizationService;
    private final Mapper<RegistrationRequest, User> registrationRequestMapper;

    /**
     * Создание пользователя.
     *
     * @param request ДТО запроса регистрации
     */
    public void createUser(RegistrationRequest request) {
        User user = registrationRequestMapper.map(request);
        authorizationService.createUser(user);
    }
}
