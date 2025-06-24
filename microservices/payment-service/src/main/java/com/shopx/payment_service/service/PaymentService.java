package com.shopx.payment_service.service;

import com.shopx.payment_service.model.dto.PaymentResponse;
import com.shopx.payment_service.model.dto.PymentRequest;

public interface PaymentService {
    public PaymentResponse makePayment(PymentRequest paymentRequest);
    public boolean verifyPayment(String gateway, String transactionId);
}
