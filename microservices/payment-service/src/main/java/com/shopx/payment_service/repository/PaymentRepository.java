package com.shopx.payment_service.repository;

import com.shopx.payment_service.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
