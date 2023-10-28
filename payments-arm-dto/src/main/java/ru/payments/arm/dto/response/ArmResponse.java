package ru.payments.arm.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Базовый ответ для сервисов АРМа
 */
@Data
@NoArgsConstructor
public class ArmResponse<T> {

    /** Тело ответа */
    private T body;

    /** Сообщения */
    private ArmMessage message;

    public ArmResponse(T body) {
        this.body = body;
    }
}