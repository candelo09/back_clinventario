package com.clsystem.clinventario.repository;

import com.clsystem.clinventario.entity.Category;
import com.clsystem.clinventario.entity.User;

import java.util.Optional;

public interface ICategoryRepository {

    public Iterable<Category> findAllCategories();

    public Optional<Category> findByIdCategory(Long id);

    public void addCategory(Category category);

    public void removeCategory(Integer id);

    public void updateCategory(Category category);

}
