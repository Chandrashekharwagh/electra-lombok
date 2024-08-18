package com.electra.service;

import com.electra.model.Payment;
import com.electra.repository.PaymentRepository;

import java.util.List;

public class PaymentService {
    private static final PaymentRepository PAYMENT_REPO = new PaymentRepository();

    // Method to retrieve user payments of the database
    public List<Payment> retrievePayments() {
        return PAYMENT_REPO.retrievePayments();

    }
}
