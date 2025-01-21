package com.clsystem.clinventario.controller;

import com.clsystem.clinventario.entity.Customer;
import com.clsystem.clinventario.services.CustomerAccessService;
import com.clsystem.clinventario.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "customers")
public class CustomerController {

    @Autowired
    private  CustomerService customerService;

    @Autowired
    private  CustomerAccessService customerAccessService;

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<?> getAllCustomers() {
        try {
            return new ResponseEntity<>(customerService.findAllCustomers(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
        try {

            customerService.addCustomer(customer);

            return new ResponseEntity<>("Customer successfully add", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<?> deleteCustomer(@PathVariable Integer id, @RequestBody Customer customer) {

        try {
            customer.setId(id);
            customerService.removeCustomer(customer);
            return new ResponseEntity<>("Customer successfully delete", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit/{id}")
    public @ResponseBody ResponseEntity<?> editUser(@PathVariable Integer id, @RequestBody Customer customer){
        try {
            customer.setId(id);
            customerService.updateCustomer(customer);
            return new ResponseEntity<>("Customer successfully edited", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

//    @GetMapping("/access/{document}")
//    public @ResponseBody ResponseEntity<?> accessCustomer(@PathVariable String document) {
//        try {
//            return new ResponseEntity<>(customerAccessService.findByCustomerAccess(document), HttpStatus.OK);
//        }catch(Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/access/{document}")
    public @ResponseBody ResponseEntity<?> accessCustomer(@PathVariable String document) {
        try {
            return new ResponseEntity<>(customerAccessService.remainingDays(document), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/access/all")
//    public @ResponseBody ResponseEntity<?> accessAllCustomer() {
//        try {
//            return new ResponseEntity<>(customerAccessService.findAllCustomerAccess(), HttpStatus.OK);
//        }catch(Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @GetMapping("/remaining/days/{document}")
//    public @ResponseBody ResponseEntity<?> remainingDays(@PathVariable String document) {
//        try {
//            return new ResponseEntity<>(customerAccessService.remainingDays(document), HttpStatus.OK);
//        }catch(Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
