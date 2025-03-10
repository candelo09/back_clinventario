package com.clsystem.clinventario.services;

import com.clsystem.clinventario.daorepository.ICustomerDaoRepository;
import com.clsystem.clinventario.daorepository.IMembershipDaoRepository;
import com.clsystem.clinventario.entity.Customer;
import com.clsystem.clinventario.entity.Membership;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Customer_Service")
@DataJpaTest
public class CustomerServiceTest {
    @Autowired
    ICustomerDaoRepository customerDao;


    @BeforeEach
    void setUp() throws Exception {
        customerDao.deleteAll();
        customerDao.save(new Customer("Test 1", "1113", "prueba@gmail.com",
                "1234567", "direccion", new Date(), 35000.0,
                new Date(), new Date(), new Date()));
        customerDao.save(new Customer("Test 2", "1114", "prueba@gmail.com",
                "1234567", "direccion", new Date(), 37000.0,
                new Date(), new Date(), new Date()));
    }

    @Test
    void testFindAll() {
        Iterable<Customer> customers = customerDao.findAll();
        assertEquals(2, ((Collection<?>) customers).size());
    }

    @Test
    void testSave() {
        // Given
        Customer customer = new Customer("Test 1", "1113", "prueba@gmail.com", "1234567",
                "direccion", new Date(), 35000.0, new Date(), new Date(), new Date());
        // When
        Customer customerSaved = customerDao.save(customer);
        // Then
        assertEquals(customer.getId(), customerSaved.getId());
        assertEquals("Test 1", customerSaved.getName());
        assertEquals("1113", customerSaved.getId_document());
        assertEquals("prueba@gmail.com", customerSaved.getEmail());
        assertEquals("direccion", customerSaved.getAddress());
        assertEquals(35000.0, customerSaved.getPurchases());
    }

    @Test
    void testFindById() {
        // Given
        Customer customer = new Customer("Test 1", "1113", "prueba@gmail.com", "1234567",
                "direccion", new Date(), 35000.0, new Date(), new Date(), new Date());
        customerDao.save(customer);
        // When
        Optional<Customer> customerFound = customerDao.findById(customer.getId());
        // Then
        assertTrue(customerFound.isPresent());
        assertEquals("Test 1", customerFound.get().getName());
        assertEquals("1113", customerFound.get().getId_document());
        assertEquals("prueba@gmail.com", customerFound.get().getEmail());
        assertEquals("direccion", customerFound.get().getAddress());
        assertEquals(35000.0, customerFound.get().getPurchases());
    }

    @Test
    void testDelete() {
        // Given
        Customer customer = new Customer("Test 1", "1113", "prueba@gmail.com", "1234567",
                "direccion", new Date(), 35000.0, new Date(), new Date(), new Date());
        customerDao.save(customer);
        // When
        customerDao.deleteById(customer.getId());
        Optional<Customer> customerFound = customerDao.findById(customer.getId());
        // Then
        assertFalse(customerFound.isPresent());
    }

}
