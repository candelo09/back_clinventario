package com.clsystem.clinventario.repository;

import com.clsystem.clinventario.entity.Product;

import java.util.Optional;

public interface IProductRepository {

    public Iterable<Product> findAllProducts();

    public Optional<Product> findByIdProducts(Integer id);

    public void addProduct(Product product);

    public void removeProduct(Product product);

    public void updateProduct(Product product);
}
