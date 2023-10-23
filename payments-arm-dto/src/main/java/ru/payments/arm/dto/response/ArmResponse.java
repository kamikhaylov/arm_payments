package ru.payments.arm.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Базовый ответ для сервисов АРМа
 */
@Data
@NoArgsConstructor
@ToString
public class ArmResponse<T> {

    /** Тело ответа */
    private T body;

    /** Сообщения */
    private ArmMessage message;

    public ArmResponse(T body) {
        this.body = body;
    }
}