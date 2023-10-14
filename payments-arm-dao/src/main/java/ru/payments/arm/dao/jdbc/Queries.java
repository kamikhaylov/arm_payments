package ru.payments.arm.dao.jdbc;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Queries {

    FIND_PAYMENT_LIST("findPaymentList");

    private final String sqlKey;
}
