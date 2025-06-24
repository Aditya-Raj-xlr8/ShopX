package com.shopx.payment_service.service.gateway;

import com.shopx.payment_service.model.dto.PaymentResponse;
import com.shopx.payment_service.model.dto.PymentRequest;

public interface PaymentGateway {
    PaymentResponse initiatePayment(PymentRequest paymentRequest);
    boolean verifyPayment(String transactionId);
}
