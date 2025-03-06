package com.clsystem.clinventario.daorepository;

import com.clsystem.clinventario.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface ICustomerDaoRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findByDocument(final String document);


}
