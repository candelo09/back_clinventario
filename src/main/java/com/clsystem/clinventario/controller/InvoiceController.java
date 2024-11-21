package com.clsystem.clinventario.controller;


import com.clsystem.clinventario.entity.Invoice;
import com.clsystem.clinventario.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<?> getAllInvoices() {
        try {
            return new ResponseEntity<>(invoiceService.findAllInvoice(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<?> saveInvoice(@RequestBody Invoice invoice) {
        try {

            invoiceService.addInvoice(invoice);

            return new ResponseEntity<>("Invoice successfully add", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<?> deleteInvoice(@PathVariable Integer id, @RequestBody Invoice invoice) {

        try {
            invoice.setId(id);
            invoiceService.removeInvoice(invoice);
            return new ResponseEntity<>("Invoice successfully delete", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit/{id}")
    public @ResponseBody ResponseEntity<?> editUser(@PathVariable Integer id, @RequestBody Invoice invoice){
        try {
            invoice.setId(id);
            invoiceService.updateInvoice(invoice);
            return new ResponseEntity<>("Invoice successfully edited", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
