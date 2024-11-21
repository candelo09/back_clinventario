package com.clsystem.clinventario.services;


import com.clsystem.clinventario.daorepository.ICategoryDaoRepository;
import com.clsystem.clinventario.entity.Category;
import com.clsystem.clinventario.entity.User;
import com.clsystem.clinventario.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryRepository {

    @Autowired
    private ICategoryDaoRepository categoryDao;

    @Override
    public Iterable<Category> findAllCategories() {
        return categoryDao.findAll();
    }

    @Override
    public Optional<Category> findByIdCategory(Long id) {
        return categoryDao.findById(id);
    }

    @Override
    public void addCategory(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void removeCategory(Category category) {
        categoryDao.delete(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryDao.save(category);
    }
}
