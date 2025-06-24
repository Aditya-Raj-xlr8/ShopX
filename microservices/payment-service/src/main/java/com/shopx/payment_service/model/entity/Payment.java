package com.shopx.payment_service.model.entity;

import com.shopx.payment_service.model.enums.PaymentMethod;
import com.shopx.payment_service.model.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "payment_record")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transactionId;
    private String orderId;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    private Date createdAt;
}
