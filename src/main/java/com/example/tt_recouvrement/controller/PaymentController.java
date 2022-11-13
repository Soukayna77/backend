package com.example.tt_recouvrement.controller;

import com.example.tt_recouvrement.model.Payment;
import com.example.tt_recouvrement.model.response.Response;
import com.example.tt_recouvrement.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payment")
@CrossOrigin("*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("")
    public Response<Payment> savePayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }

    @PutMapping("{id_payment}")
    public Response<Payment> updatePayment(@RequestBody Payment payment,@PathVariable String id_payment) {
        return paymentService.updatePayment(payment,id_payment);
    }

    @DeleteMapping("{id_payment}")
    public Response<Payment> deletePayment(@PathVariable String id_payment) {
        return paymentService.deletePayment(id_payment);
    }

    @GetMapping("")
    public Response<List<Payment>> getAllPayment() {
        return paymentService.getAll();
    }

    @GetMapping("{id_payment}")
    public Response<Payment> getByIdPayment(@PathVariable String id_payment) {
        return paymentService.getByIdPayment(id_payment);
    }
}
