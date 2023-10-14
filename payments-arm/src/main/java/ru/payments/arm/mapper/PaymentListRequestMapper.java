package ru.payments.arm.mapper;

import org.modelmapper.ModelMapper;
import ru.payments.arm.dao.context.PaymentListDaoContext;
import ru.payments.arm.service.context.PaymentListContext;

/**
 * Маппер контекста запроса сервиса получения списка платежей в ДАО контекст
 */
public class PaymentListRequestMapper implements Mapper<PaymentListContext, PaymentListDaoContext> {

    private final ModelMapper mapper;

    public PaymentListRequestMapper() {
        this.mapper = new ModelMapper();
        this.mapper.getConfiguration().setSkipNullEnabled(true);
        this.mapper.createTypeMap(PaymentListContext.class, PaymentListDaoContext.class);
    }

    @Override
    public PaymentListDaoContext map(PaymentListContext context) {
        return this.mapper.map(context, PaymentListDaoContext.class);
    }
}
