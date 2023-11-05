package ru.payments.arm.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.payments.arm.dao.api.PaymentListDao;
import ru.payments.arm.dao.context.PaymentListDaoContext;
import ru.payments.arm.dao.dto.PaymentListDaoDto;
import ru.payments.arm.dto.response.PaymentListResponse;
import ru.payments.arm.mapper.Mapper;
import ru.payments.arm.service.context.PaymentListContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class PaymentListServiceTest {

    private static final String PAYMENT_ID = "123";
    private static final String CLIENT_ID = "321";

    private PaymentListService paymentListService;

    @Mock
    private PaymentListDao paymentListDao;
    @Mock
    private Mapper<PaymentListContext, PaymentListDaoContext> paymentListRequestMapper;
    @Mock
    private Mapper<PaymentListDaoDto, PaymentListResponse> paymentListResponseMapper;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
        paymentListService = new PaymentListService(paymentListDao, paymentListRequestMapper, paymentListResponseMapper);
    }

    @AfterEach
    public void after() {
        Mockito.reset(paymentListDao, paymentListRequestMapper, paymentListResponseMapper);
    }

    @Test
    public void testGetPaymentList() {
        PaymentListContext context = new PaymentListContext();
        PaymentListDaoContext daoContext = new PaymentListDaoContext();
        PaymentListDaoDto paymentList = createPaymentListDaoDto();
        PaymentListResponse paymentListResponse = createPaymentListResponse();
        List<PaymentListDaoDto> payments = List.of(paymentList);
        List<PaymentListResponse> expected = List.of(paymentListResponse);

        when(paymentListRequestMapper.map(context)).thenReturn(daoContext);
        when(paymentListDao.getPaymentList(daoContext)).thenReturn(payments);
        when(paymentListResponseMapper.map(paymentList)).thenReturn(paymentListResponse);

        List<PaymentListResponse> actual = paymentListService.getPaymentList(context);

        assertNotNull(actual);
        assertEquals(expected, actual);
        verify(paymentListRequestMapper).map(context);
        verify(paymentListDao).getPaymentList(daoContext);
        verify(paymentListResponseMapper).map(paymentList);
        verifyNoMoreInteractions(paymentListRequestMapper, paymentListDao, paymentListResponseMapper);
    }

    private PaymentListDaoDto createPaymentListDaoDto() {
        PaymentListDaoDto result = new PaymentListDaoDto();
        result.setPaymentId(PAYMENT_ID);
        result.setClientId(CLIENT_ID);
        return result;
    }

    private PaymentListResponse createPaymentListResponse() {
        PaymentListResponse result = new PaymentListResponse();
        result.setPaymentId(PAYMENT_ID);
        result.setClientId(CLIENT_ID);
        return result;
    }
}