package ru.payments.arm.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.payments.arm.dao.api.PaymentDetailsDao;
import ru.payments.arm.dao.dto.PaymentDetailsDaoDto;
import ru.payments.arm.dto.request.PaymentDetailsRequest;
import ru.payments.arm.dto.response.PaymentDetailsResponse;
import ru.payments.arm.mapper.Mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class PaymentDetailsServiceTest {

    @InjectMocks
    private PaymentDetailsService paymentDetailsService;
    @Mock
    private PaymentDetailsDao paymentDetailsDao;
    @Mock
    private Mapper<PaymentDetailsDaoDto, PaymentDetailsResponse> paymentDetailsResponseMapper;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void after() {
        Mockito.reset(paymentDetailsDao, paymentDetailsResponseMapper);
    }

    @Test
    public void testGetPaymentDetails() {
        PaymentDetailsRequest request = new PaymentDetailsRequest();
        PaymentDetailsDaoDto paymentDetails = new PaymentDetailsDaoDto();
        PaymentDetailsResponse expected = new PaymentDetailsResponse();
        when(paymentDetailsDao.getById(request.getPaymentId())).thenReturn(paymentDetails);
        when(paymentDetailsResponseMapper.map(paymentDetails)).thenReturn(expected);

        PaymentDetailsResponse actual = paymentDetailsService.getPaymentDetails(request);

        assertNotNull(actual);
        assertEquals(expected, actual);
        verify(paymentDetailsDao).getById(request.getPaymentId());
        verify(paymentDetailsResponseMapper).map(paymentDetails);
        verifyNoMoreInteractions(paymentDetailsDao, paymentDetailsResponseMapper);
    }
}