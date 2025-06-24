package com.shopx.payment_service.controller;

import com.shopx.payment_service.model.dto.PaymentResponse;
import com.shopx.payment_service.model.dto.PymentRequest;
import com.shopx.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;


    @PostMapping("/initPayment")
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponse makePayment(@RequestBody PymentRequest paymentRequest) {
        return paymentService.makePayment(paymentRequest);
    }


}
