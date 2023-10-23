package ru.payments.arm.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Сообщения АРМа
 */
@Data
@NoArgsConstructor
@ToString
public class ArmMessage {

    /** Сообщение об ошибке */
    private String error;

    /** Информационное сообщение */
    private String info;
}
