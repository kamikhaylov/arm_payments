package ru.payments.arm.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.payments.arm.dao.api.PaymentTypeDao;
import ru.payments.arm.dao.dto.PaymentTypeDaoDto;
import ru.payments.arm.dao.dto.PaymentTypesFindDaoRequest;
import ru.payments.arm.dto.request.DeletePaymentTypeRequest;
import ru.payments.arm.dto.request.MergePaymentTypeRequest;
import ru.payments.arm.dto.request.PaymentTypesFindRequest;
import ru.payments.arm.dto.response.PaymentTypesFindResponse;
import ru.payments.arm.mapper.Mapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class PaymentTypesServiceTest {

    private PaymentTypesService paymentTypesService;

    @Mock
    private PaymentTypeDao paymentTypeDao;
    @Mock
    private Mapper<PaymentTypesFindRequest, PaymentTypesFindDaoRequest> paymentTypesFindRequestMapper;
    @Mock
    private Mapper<PaymentTypeDaoDto, PaymentTypesFindResponse> paymentTypesFindResponseMapper;
    @Mock
    private Mapper<MergePaymentTypeRequest, PaymentTypeDaoDto> mergePaymentTypeRequestMapper;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
        paymentTypesService = new PaymentTypesService(paymentTypeDao, paymentTypesFindRequestMapper,
                paymentTypesFindResponseMapper, mergePaymentTypeRequestMapper);
    }

    @AfterEach
    public void after() {
        Mockito.reset(paymentTypeDao, paymentTypesFindRequestMapper,
                paymentTypesFindResponseMapper, mergePaymentTypeRequestMapper);
    }

    @Test
    public void testFindTypes() {
        PaymentTypesFindRequest request = new PaymentTypesFindRequest();
        PaymentTypesFindDaoRequest daoRequest = new PaymentTypesFindDaoRequest();
        PaymentTypeDaoDto paymentType = new PaymentTypeDaoDto();
        PaymentTypesFindResponse paymentTypesFindResponse = new PaymentTypesFindResponse();
        List<PaymentTypeDaoDto> types = List.of(paymentType);
        List<PaymentTypesFindResponse> expected = List.of(paymentTypesFindResponse);

        when(paymentTypesFindRequestMapper.map(request)).thenReturn(daoRequest);
        when(paymentTypeDao.findTypes(daoRequest)).thenReturn(types);
        when(paymentTypesFindResponseMapper.map(paymentType)).thenReturn(paymentTypesFindResponse);

        List<PaymentTypesFindResponse> actual = paymentTypesService.findTypes(request);

        assertNotNull(actual);
        assertEquals(expected, actual);
        verify(paymentTypesFindRequestMapper).map(request);
        verify(paymentTypeDao).findTypes(daoRequest);
        verify(paymentTypesFindResponseMapper).map(paymentType);
        verifyNoMoreInteractions(paymentTypeDao, paymentTypesFindRequestMapper,
                paymentTypesFindResponseMapper, mergePaymentTypeRequestMapper);
    }

    @Test
    public void testMergeType() {
        MergePaymentTypeRequest request = new MergePaymentTypeRequest();
        PaymentTypeDaoDto paymentType = new PaymentTypeDaoDto();

        when(mergePaymentTypeRequestMapper.map(request)).thenReturn(paymentType);

        paymentTypesService.mergeType(request);

        verify(mergePaymentTypeRequestMapper).map(request);
        verify(paymentTypeDao).merge(paymentType);
        verifyNoMoreInteractions(paymentTypeDao, paymentTypesFindRequestMapper,
                paymentTypesFindResponseMapper, mergePaymentTypeRequestMapper);
    }

    @Test
    public void testDeleteType() {
        DeletePaymentTypeRequest request = new DeletePaymentTypeRequest();
        request.setType("type");

        paymentTypesService.deleteType(request);

        verify(paymentTypeDao).delete(request.getType());
        verifyNoMoreInteractions(paymentTypeDao, paymentTypesFindRequestMapper,
                paymentTypesFindResponseMapper, mergePaymentTypeRequestMapper);
    }
}