package com.clsystem.clinventario.controller;


import ch.qos.logback.core.model.Model;
import com.clsystem.clinventario.entity.Category;
import com.clsystem.clinventario.entity.User;
import com.clsystem.clinventario.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
@RequestMapping(path = "categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<?> getAllCategories() {
        try {
            return new ResponseEntity<>(categoryService.findAllCategories(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<?> saveCategory(@RequestBody Category category) {
        try {

            categoryService.addCategory(category);

            return new ResponseEntity<>("Category successfully add", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<?> deleteCategory(@PathVariable Integer id, @RequestBody Category category) {

        try {
            category.setId(id);
            categoryService.removeCategory(category);
            return new ResponseEntity<>("Category successfully delete", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit/{id}")
    public @ResponseBody ResponseEntity<?> editUser(@PathVariable Integer id, @RequestBody Category category){
        try {
            category.setId(id);
            categoryService.updateCategory(category);
            return new ResponseEntity<>("Category successfully edited", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
