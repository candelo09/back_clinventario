package com.clsystem.clinventario.daorepository;

import com.clsystem.clinventario.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerDaoRepository extends CrudRepository<Customer, Integer> {
}
