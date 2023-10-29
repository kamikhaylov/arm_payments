package ru.payments.arm.dao.jdbc;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Queries {

    FIND_PAYMENT_LIST("findPaymentList"),
    FIND_PAYMENT_DETAILS("findPaymentDetails"),
    FIND_PAYMENT_TYPE_LIST("findPaymentTypeList");

    private final String sqlKey;
}
