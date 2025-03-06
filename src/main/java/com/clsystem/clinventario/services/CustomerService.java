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
    public Optional<Customer> findByIdCustomer(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void addCustomer(Customer customer) {
        
        customerRepository.save(customer);

    }

    @Override
    public void removeCustomerById(Integer id) {
        
        customerRepository.deleteById(Long.valueOf(id));

    }

    @Override
    public void updateCustomer(Customer customer) {
        
        customerRepository.save(customer);
        

    }

    @Override
    public Optional<Customer> findByDocument(String idDocument) {
        return this.customerRepository.findByDocument(idDocument);
    }

}
