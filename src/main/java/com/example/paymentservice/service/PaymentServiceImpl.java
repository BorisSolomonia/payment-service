package com.example.paymentservice.service;

import com.example.paymentservice.entity.TransactionDetails;
import com.example.paymentservice.model.PaymentRequest;
import com.example.paymentservice.model.PaymentResponse;
import com.example.paymentservice.repository.TransactionRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    TransactionRepository transactionRepository;
    @Override
    public Long doPayment(PaymentRequest paymentRequest) {
        log.info("Recording Payment Details: {}", paymentRequest);
        TransactionDetails transactionDetails =
                TransactionDetails
                        .builder()
                        .paymentMode(paymentRequest.getPaymentMode())
                        .paymentDate(Instant.now()).paymentStatus("SUCCESS")
                        .orderId(paymentRequest.getOrderId())
                        .referenceNumber(paymentRequest.getReferenceNumber())
                        .amount(paymentRequest.getAmount())
                        .build();
        transactionRepository.save(transactionDetails);
        log.info("Payment Details Recorded: {}", transactionDetails);
        return transactionDetails.getId();
    }

    @Override
    public PaymentResponse getPaymentByOrderId(Long orderId) {
        log.info("getting payment by order id");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        TransactionDetails transactionDetails = transactionRepository.getTransactionDetailsByOrderId(orderId);
        PaymentResponse paymentResponse = PaymentResponse
                .builder()
                .paymentId(transactionDetails.getId())
                .paymentDate(transactionDetails.getPaymentDate())
                .paymentMode(transactionDetails.getPaymentMode())
                .status(transactionDetails.getPaymentStatus())
                .orderId(transactionDetails.getOrderId())
                .amount(transactionDetails.getAmount())
                .build();
        log.info("got payment by order id");
        return paymentResponse;
    }


}
