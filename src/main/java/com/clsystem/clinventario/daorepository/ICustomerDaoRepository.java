package com.clsystem.clinventario.daorepository;

import com.clsystem.clinventario.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface ICustomerDaoRepository extends CrudRepository<Customer, Integer> {

    @Query(value = "select * " +
            "from payments p " +
            "left join customers c on c.id = p.id_customer " +
            "left join memberships m on m.id = p.id_membership " +
            "where c.id_document = :document", nativeQuery = true)
    public Optional<Customer> findByDocumentAccess(@Param("document") String document);


}
