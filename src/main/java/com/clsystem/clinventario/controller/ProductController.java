package com.clsystem.clinventario.controller;



import com.clsystem.clinventario.entity.Product;
import com.clsystem.clinventario.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<?> getAllProducts() {
        try {
            return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<?> saveProduct(@RequestBody Product product) {
        try {

            productService.addProduct(product);

            return new ResponseEntity<>("", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<?> deleteProduct(@PathVariable Integer id, @RequestBody Product product) {

        try {
            product.setId(id);
            productService.removeProduct(product);
            return new ResponseEntity<>("", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit/{id}")
    public @ResponseBody ResponseEntity<?> editUser(@PathVariable Integer id, @RequestBody Product product){
        try {
            product.setId(id);
            productService.updateProduct(product);
            return new ResponseEntity<>("", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
