package com.clsystem.clinventario.daorepository;

import com.clsystem.clinventario.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductDaoRepository extends CrudRepository<Product, Integer> {
}
