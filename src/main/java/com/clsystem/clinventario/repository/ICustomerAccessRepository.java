package com.clsystem.clinventario.repository;


import com.clsystem.clinventario.entity.Customer;
import com.clsystem.clinventario.entity.CustomerAccess;
import com.clsystem.clinventario.entity.Payment;

import java.util.Map;
import java.util.Optional;

public interface ICustomerAccessRepository {

    Optional<CustomerAccess> findByCustomerAccess(String document);

    Map<String,Long> remainingDays(String document);

}
