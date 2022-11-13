package com.example.tt_recouvrement.repository;

import com.example.tt_recouvrement.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends MongoRepository<Payment,String> {
}
