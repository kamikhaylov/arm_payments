package ru.payments.arm.dao.logging;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.payments.arm.logger.api.LogEvent;

import static ru.payments.arm.dao.logging.PaymentDaoLogEvent.DAO0001;
import static ru.payments.arm.dao.logging.PaymentDaoLogEvent.DAO0002;
import static ru.payments.arm.dao.logging.PaymentDaoLogEvent.DAO0003;
import static ru.payments.arm.dao.logging.PaymentDaoLogEvent.DAO0004;
import static ru.payments.arm.dao.logging.PaymentDaoLogEvent.DAO0005;
import static ru.payments.arm.dao.logging.PaymentDaoLogEvent.DAO0006;
import static ru.payments.arm.dao.logging.PaymentDaoLogEvent.DAO0007;
import static ru.payments.arm.dao.logging.PaymentDaoLogEvent.DAO0008;
import static ru.payments.arm.dao.logging.PaymentDaoLogEvent.DAO0009;
import static ru.payments.arm.dao.logging.PaymentDaoLogEvent.DAO0010;
import static ru.payments.arm.dao.logging.PaymentDaoLogEvent.DAO0011;
import static ru.payments.arm.dao.logging.PaymentDaoLogEvent.DAO0012;
import static ru.payments.arm.dao.logging.PaymentDaoLogEvent.DAO0013;
import static ru.payments.arm.dao.logging.PaymentDaoLogEvent.DAO0014;
import static ru.payments.arm.dao.logging.PaymentDaoLogEvent.DAO0015;

/**
 * Точки событий для журналирования.
 */
@AllArgsConstructor
@Getter
public enum DaoLogPoint {

    GET_PAYMENT_LIST_DAO_LOG(DAO0001, DAO0002, DAO0003),
    GET_PAYMENT_DETAILS_DAO_LOG(DAO0004, DAO0005, DAO0006),
    FIND_PAYMENT_TYPES_DAO_LOG(DAO0007, DAO0008, DAO0009),
    MERGE_PAYMENT_TYPE_DAO_LOG(DAO0010, DAO0011, DAO0012),
    DELETE_PAYMENT_TYPE_DAO_LOG(DAO0013, DAO0014, DAO0015);

    private final LogEvent start;
    private final LogEvent finish;
    private final LogEvent error;
}
