package com.clsystem.clinventario.services;

import com.clsystem.clinventario.daorepository.IAccessCustomerDaoRepository;
import com.clsystem.clinventario.entity.Customer;
import com.clsystem.clinventario.entity.CustomerAccess;
import com.clsystem.clinventario.repository.ICustomerAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service

public class CustomerAccessService implements ICustomerAccessRepository {

    @Autowired
    private IAccessCustomerDaoRepository accessCustomerDaoRepository;

    @Override
    public Optional<CustomerAccess> findByCustomerAccess(String document) {

        return accessCustomerDaoRepository.findByDocumentAccess(document);
    }

    @Override
    public Map<String, Long> remainingDays(String document) {
        Map<String, Long> remainingDays = new HashMap<>();
        var customerAccess =
                accessCustomerDaoRepository.findByDocumentAccess(document);
        if (customerAccess.isPresent()) {
            long diff = customerAccess.get().getMembership_end_date().getTime() - new Date().getTime();
            long days  = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            remainingDays.put("remaining_days", days);
            System.out.println(days);
        }
        return remainingDays;
    }
}
