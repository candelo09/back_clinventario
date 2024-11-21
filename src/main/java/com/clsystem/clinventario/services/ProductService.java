package com.clsystem.clinventario.services;

import com.clsystem.clinventario.daorepository.IProductDaoRepository;
import com.clsystem.clinventario.entity.Product;
import com.clsystem.clinventario.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductRepository {

    @Autowired
    private IProductDaoRepository productDao;

    @Override
    public Iterable<Product> findAllProducts() {
        return productDao.findAll();
    }

    @Override
    public Optional<Product> findByIdProducts(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public void addProduct(Product product) {

        productDao.save(product);

    }

    @Override
    public void removeProduct(Product product) {

        productDao.delete(product);

    }

    @Override
    public void updateProduct(Product product) {

        productDao.save(product);

    }
}
