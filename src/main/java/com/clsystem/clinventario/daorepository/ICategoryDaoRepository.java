package com.clsystem.clinventario.daorepository;

import com.clsystem.clinventario.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryDaoRepository extends CrudRepository<Category, Long> {
}
