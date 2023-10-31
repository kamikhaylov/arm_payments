package ru.payments.arm.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * ДТО запроса регистрации
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegistrationRequest {

    /** Логин */
    private String login;

    /** Пароль */
    private String password;

    /** Почтовый ящик */
    private String email;
}
