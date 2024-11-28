package com.clsystem.clinventario.daorepository;

import com.clsystem.clinventario.entity.CustomerAccess;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IAccessCustomerDaoRepository extends CrudRepository<CustomerAccess, Long> {

    @Query(value = "select p.*, c.name, c.id_document, c.email, m.type_membership, " +
            "pp.weight,pp.body_fat, pp.musculature, pp.stature " +
            "from payments p " +
            "left join customers c on c.id = p.id_customer " +
            "left join memberships m on m.id = p.id_membership " +
            "left join physical_progress pp on pp.id_customer = c.id " +
            "where c.id_document = :document", nativeQuery = true)
    Optional<CustomerAccess> findByDocumentAccess(@Param("document") String document);
}
