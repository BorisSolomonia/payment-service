package com.example.paymentservice.repository;

import com.example.paymentservice.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionDetails,Long> {

    public TransactionDetails getTransactionDetailsByOrderId(Long orderId);
}
