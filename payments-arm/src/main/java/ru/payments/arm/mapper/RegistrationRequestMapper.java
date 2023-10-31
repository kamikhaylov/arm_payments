package ru.payments.arm.mapper;

import org.modelmapper.ModelMapper;
import ru.payments.arm.auth.model.User;
import ru.payments.arm.dto.request.RegistrationRequest;

/**
 * Маппер запроса регистрации пользователя в ДАО запрос
 */
public class RegistrationRequestMapper implements Mapper<RegistrationRequest, User> {

    private final ModelMapper mapper;

    public RegistrationRequestMapper() {
        this.mapper = new ModelMapper();
        this.mapper.getConfiguration().setSkipNullEnabled(true);
    }

    @Override
    public User map(RegistrationRequest request) {
        return this.mapper.map(request, User.class);
    }
}
