package com.clsystem.clinventario.repository;

import com.clsystem.clinventario.entity.Customer;


import java.util.Optional;

public interface ICustomerRepository {

    public Iterable<Customer> findAllCustomers();

    public Optional<Customer> findByIdCustomer(Integer id);

    public void addCustomer(Customer customer);

    public void removeCustomer(Customer customer);

    public void updateCustomer(Customer customer);
}
