package com.shopx.payment_service.service;

import com.shopx.payment_service.model.dto.PaymentResponse;
import com.shopx.payment_service.model.dto.PymentRequest;
import com.shopx.payment_service.model.entity.Payment;
import com.shopx.payment_service.repository.PaymentRepository;
import com.shopx.payment_service.service.gateway.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final Map<String, PaymentGateway> paymentGateways;

    private final PaymentRepository paymentRepository;

    @Override
    public PaymentResponse makePayment(PymentRequest paymentRequest) {
        PaymentGateway paymentGateway = paymentGateways.get(paymentRequest.gateway());
        if (paymentGateway == null) {
            throw new IllegalArgumentException("Payment gateway not found: " + paymentRequest.gateway());
        }
        try {
            PaymentResponse paymentResponse = paymentGateway.initiatePayment(paymentRequest);
            Payment payment = Payment.builder()
                    .transactionId(paymentResponse.transactionId())
                    .orderId(paymentRequest.orderId())
                    .status(paymentResponse.status())
                    .paymentMethod(paymentRequest.paymentMethod())
                    .amount(paymentRequest.amount())
                    .status(paymentResponse.status())
                    .createdAt(new Date())
                    .build();

            paymentRepository.save(payment);

            return paymentResponse;

        } catch (Exception e) {
            throw new RuntimeException("Error initiating payment with " + paymentRequest.gateway(), e);
        }
    }

    public boolean verifyPayment(String gateway, String transactionId) {
        PaymentGateway paymentGateway = paymentGateways.get(gateway);
        if (paymentGateway == null) {
            throw new IllegalArgumentException("Payment gateway not found: " + gateway);
        }
        try {
            return paymentGateway.verifyPayment(transactionId);
        } catch (Exception e) {
            throw new RuntimeException("Error verifying payment with " + gateway, e);
        }
    }
}
