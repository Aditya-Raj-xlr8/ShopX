package com.shopx.payment_service.service.gateway;

import com.shopx.payment_service.model.dto.PaymentResponse;
import com.shopx.payment_service.model.dto.PymentRequest;
import com.shopx.payment_service.model.enums.PaymentStatus;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service("razorpay")
public class RazorPay implements PaymentGateway{

    private static final Random RANDOM = new Random();


    private PaymentStatus getRandomPaymentStatus() {
        return RANDOM.nextBoolean() ? PaymentStatus.SUCCESS : PaymentStatus.FAILED;
    }

    @Override
    public PaymentResponse initiatePayment(PymentRequest paymentRequest) {
        String transactionId = "razorpay_" + System.currentTimeMillis();
        return PaymentResponse.builder()
                .transactionId(transactionId)
                .orderId(paymentRequest.orderId())
                .status(getRandomPaymentStatus())
                .build();
    }

    @Override
    public boolean verifyPayment(String transactionId) {
        return RANDOM.nextBoolean();
    }
}
