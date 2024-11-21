package com.clsystem.clinventario.controller;


import com.clsystem.clinventario.entity.Payment;
import com.clsystem.clinventario.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<?> getAllPayments() {
        try {
            return new ResponseEntity<>(paymentService.findAllPayments(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<?> savePayment(@RequestBody Payment payment) {
        try {

            paymentService.addPayment(payment);

            return new ResponseEntity<>("Payment successfully add", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<?> deletePayment(@PathVariable Integer id, @RequestBody Payment payment) {

        try {
            payment.setId(id);
            paymentService.removePayment(payment);
            return new ResponseEntity<>("Payment successfully delete", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit/{id}")
    public @ResponseBody ResponseEntity<?> editUser(@PathVariable Integer id, @RequestBody Payment payment){
        try {
            payment.setId(id);
            paymentService.updatePayment(payment);
            return new ResponseEntity<>("Payment successfully edited", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
