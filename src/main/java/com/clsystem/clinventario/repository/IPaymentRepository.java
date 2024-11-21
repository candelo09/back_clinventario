package com.clsystem.clinventario.repository;


import com.clsystem.clinventario.entity.Payment;

import java.util.Optional;

public interface IPaymentRepository {

    public Iterable<Payment> findAllPayments();

    public Optional<Payment> findByIdPayment(Long id);

    public void addPayment(Payment payment);

    public void removePayment(Payment payment);

    public void updatePayment(Payment payment);
}
