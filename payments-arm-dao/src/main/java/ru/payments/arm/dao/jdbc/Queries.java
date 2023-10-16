package ru.payments.arm.dao.jdbc;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Queries {

    FIND_PAYMENT_LIST("findPaymentList"),
    FIND_PAYMENT_DETAILS("findPaymentDetails");

    private final String sqlKey;
}
