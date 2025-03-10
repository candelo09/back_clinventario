package com.clsystem.clinventario.services;

import com.clsystem.clinventario.daorepository.ICategoryDaoRepository;
import com.clsystem.clinventario.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Optional;

@Tag("Category_Service")
@DataJpaTest
public class CategoryServiceTest {

    @Autowired
    ICategoryDaoRepository categoryRepository;

    @BeforeEach
    void setUp() {
        categoryRepository.deleteAll();
    }

    @Test
    void testFindAll() {
        categoryRepository.save(new Category(null, "BEBIDAS MODIFICADAS"));
        categoryRepository.save(new Category(null, "AROMATICAS"));
        Iterable<Category> categories = categoryRepository.findAll();
        assertEquals(2, ((Collection<?>) categories).size());
    }

    @Test
    void testSave() {
        Category category = new Category(1, "BEBIDAS MODIFICADAS");

        Category category2 = categoryRepository.save(category);
        assertEquals("BEBIDAS MODIFICADAS" , category2.getCategory());
    }

    @Test
    void testFindById() {
        // Given
        Category cat = categoryRepository.save(new Category(null, "BEBIDAS MODIFICADAS"));
        Category cat2 = categoryRepository.save(new Category(null, "AROMATICAS"));
        //When
        Optional<Category> category = categoryRepository.findById(cat.getId_category().longValue());
        Optional<Category> category2 = categoryRepository.findById(cat2.getId_category().longValue());
        //Then
        assertTrue(category.isPresent());
        assertTrue(category2.isPresent());
        assertEquals("BEBIDAS MODIFICADAS", category.get().getCategory());
        assertEquals("AROMATICAS", category2.get().getCategory());
    }

    @Test
    void testDelete() {
        // Given
        Category cat = categoryRepository.save(new Category(null, "BEBIDAS MODIFICADAS"));
        // When
        categoryRepository.deleteById(cat.getId_category().longValue());
        Optional<Category> categoryValidator = categoryRepository.findById(cat.getId_category().longValue());

        assertTrue(categoryValidator.isEmpty());
    }

}
