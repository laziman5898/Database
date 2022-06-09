package com.tsi.lerai.foulkes.program.controller;

import com.tsi.lerai.foulkes.program.repoandobj.payment.Payment;
import com.tsi.lerai.foulkes.program.repoandobj.payment.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentRepo paymentRepo;

    public PaymentController(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    @GetMapping("/payment")
    public List<Payment> getAllPaymentInfo() {
        return (List<Payment>) paymentRepo.findAll();
    }
}
