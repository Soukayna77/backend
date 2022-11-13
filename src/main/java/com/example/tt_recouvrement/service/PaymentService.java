package com.example.tt_recouvrement.service;


import com.example.tt_recouvrement.model.Payment;
import com.example.tt_recouvrement.model.response.Response;
import com.example.tt_recouvrement.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Response<Payment> savePayment(Payment payment) {
        payment.setCreated(new Date());
        return new Response<>("200","save Payment",paymentRepository.save(payment));
    }

    public Response<Payment> updatePayment(Payment payment, String id_payment) {
        payment.setId(id_payment);
        return new Response<>("200","update Payment",paymentRepository.save(payment));
    }

    public Response<List<Payment>> getAll() {
        return new Response<>("200","all Payment",paymentRepository.findAll());
    }

    public Response<Payment> deletePayment(String id_payment) {
        try{
            paymentRepository.findById(id_payment).get();
            paymentRepository.deleteById(id_payment);
            return new Response<>("200","deleted Payment",null);
        } catch (Exception e) {
            return new Response<>("406","not found Payment",null);
        }
    }

    public Response<Payment> getByIdPayment(String id_payment) {
        try{
            return new Response<>("200","get Payment with id "+id_payment,paymentRepository.findById(id_payment).get());
        } catch (Exception e) {
            return new Response<>("406","Payment not found",null);
        }
    }
}
