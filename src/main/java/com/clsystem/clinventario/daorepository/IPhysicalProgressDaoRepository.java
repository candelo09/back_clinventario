package com.clsystem.clinventario.daorepository;

import com.clsystem.clinventario.entity.Category;
import com.clsystem.clinventario.entity.PhysicalProgress;
import org.springframework.data.repository.CrudRepository;

public interface IPhysicalProgressDaoRepository extends CrudRepository<PhysicalProgress, Long> {

//    PhysicalProgress findByCus
}
