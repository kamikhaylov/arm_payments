package ru.payments.arm.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Сообщения АРМа
 */
@Data
@NoArgsConstructor
public class ArmMessage {

    /** Сообщение об ошибке */
    private String error;

    /** Информационное сообщение */
    private String info;
}
