package com.clsystem.clinventario.daorepository;

import com.clsystem.clinventario.entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface IPaymentDaoRepository extends CrudRepository<Payment, Long> {
}
