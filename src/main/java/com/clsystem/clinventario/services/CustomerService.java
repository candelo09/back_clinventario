package com.clsystem.clinventario.services;

import com.clsystem.clinventario.daorepository.ICustomerDaoRepository;
import com.clsystem.clinventario.entity.Customer;
import com.clsystem.clinventario.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerRepository {
    
    @Autowired
    private ICustomerDaoRepository customerRepository;
    
    @Override
    public Iterable<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findByIdCustomer(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void addCustomer(Customer customer) {
        
        customerRepository.save(customer);

    }

    @Override
    public void removeCustomer(Customer customer) {
        
        customerRepository.delete(customer);

    }

    @Override
    public void updateCustomer(Customer customer) {
        
        customerRepository.save(customer);
        

    }

}
