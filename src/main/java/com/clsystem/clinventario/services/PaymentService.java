package com.clsystem.clinventario.services;

import com.clsystem.clinventario.daorepository.IPaymentDaoRepository;
import com.clsystem.clinventario.entity.Membership;
import com.clsystem.clinventario.entity.Payment;
import com.clsystem.clinventario.repository.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class PaymentService implements IPaymentRepository {

    @Autowired
    private IPaymentDaoRepository paymentDao;

    @Autowired
    private MembershipService membershipService;

    @Override
    public Iterable<Payment> findAllPayments() {
        return paymentDao.findAll();
    }

    @Override
    public Optional<Payment> findByIdPayment(Long id) {
        return paymentDao.findById(id);
    }

    @Override
    public void addPayment(Payment payment) {

        Date date = new Date();

        payment.setPaid_date(date);

        payment.setMembership_start_date(date);
        payment.setMembership_end_date(date);

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        Optional<Membership> membership = membershipService.findByIdMembership(payment.getId_membership());

        //AtomicReference<Integer> id_plan_membership = new AtomicReference<>(0);
        membership.ifPresent(value -> {
            //id_plan_membership.set(value.getCode_plan());

            if (value.getCode_plan() == 1) {
                calendar.add(Calendar.MONTH, 1);
                payment.setMembership_end_date(calendar.getTime());
            }

            if (value.getCode_plan().equals(2)) {
                calendar.add(Calendar.MONTH, 6);
                payment.setMembership_end_date(calendar.getTime());
            }

            if (value.getCode_plan().equals(3)) {
                calendar.add(Calendar.YEAR, 1);
                payment.setMembership_end_date(calendar.getTime());
            }

            if (value.getCode_plan().equals(4) || value.getCode_plan().equals(5)) {
                calendar.add(Calendar.HOUR, 1);
                payment.setMembership_end_date(calendar.getTime());
            }


        });

        paymentDao.save(payment);

    }

    @Override
    public void removePayment(Payment payment) {

        paymentDao.delete(payment);

    }

    @Override
    public void updatePayment(Payment payment) {

        paymentDao.save(payment);

    }
}
