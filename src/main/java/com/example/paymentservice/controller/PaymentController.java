package com.example.paymentservice.controller;

import com.example.paymentservice.model.PaymentRequest;
import com.example.paymentservice.model.PaymentResponse;
import com.example.paymentservice.service.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentServiceImpl paymentService;

    @PostMapping("/dopayment")
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest){
        System.out.println("Doing Payment!!!!!!!");
        return new ResponseEntity<>(paymentService.doPayment(paymentRequest), HttpStatus.OK);
    }

    @GetMapping("/get_payment_by_orderid/{orderId}")
    public ResponseEntity<PaymentResponse> getPaymentByOrderId(@PathVariable Long orderId){
        System.out.println("ssssssssssssssssssssssssssssssssss");
        return new ResponseEntity<>(paymentService.getPaymentByOrderId(orderId), HttpStatus.OK);
    }
}
