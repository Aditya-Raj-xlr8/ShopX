package com.shopx.payment_service.model.dto;

import com.shopx.payment_service.model.enums.PaymentStatus;
import lombok.Builder;

@Builder
public record PaymentResponse(String transactionId,
                              String orderId,
                              PaymentStatus status) {

}
