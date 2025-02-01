package com.clsystem.clinventario.services;

import com.clsystem.clinventario.daorepository.ICategoryDaoRepository;
import com.clsystem.clinventario.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

@Tag("Category_Service")
@DataJpaTest
public class CategoryServiceTest {

    @Autowired
    ICategoryDaoRepository categoryRepository;

    @BeforeEach
    void setUp() {
        categoryRepository.deleteAll();
        categoryRepository.save(new Category(1, "BEBIDAS MODIFICADAS"));
        categoryRepository.save(new Category(12, "AROMATICAS"));
    }
    @Test
    void testFindById() {
        Optional<Category> category = categoryRepository.findById(1L);
        Optional<Category> category2 = categoryRepository.findById(2L);
        assertTrue(category.isPresent());
        assertTrue(category2.isPresent());
        assertEquals("BEBIDAS MODIFICADAS", category.get().getCategory());
        assertEquals("AROMATICAS", category2.get().getCategory());
    }
}
