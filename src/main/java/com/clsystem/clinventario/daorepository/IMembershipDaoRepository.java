package com.clsystem.clinventario.daorepository;

import com.clsystem.clinventario.entity.Membership;
import org.springframework.data.repository.CrudRepository;

public interface IMembershipDaoRepository extends CrudRepository<Membership, Long> {
}
