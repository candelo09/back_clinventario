package com.clsystem.clinventario.repository;

import com.clsystem.clinventario.entity.Customer;


import java.util.Optional;

public interface ICustomerRepository {

    public Iterable<Customer> findAllCustomers();

    public Optional<Customer> findByIdCustomer(Long id);

    public void addCustomer(Customer customer);

    public void removeCustomerById(Integer id);

    public void updateCustomer(Customer customer);

    Optional<Customer> findByDocument(String idDocument);
}
