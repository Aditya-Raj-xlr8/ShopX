package com.shopx.payment_service.model.dto;


import com.shopx.payment_service.model.enums.PaymentMethod;

import java.math.BigDecimal;

public record PymentRequest(
        String orderId,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String gateway) {
}
