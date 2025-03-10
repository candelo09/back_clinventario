package com.clsystem.clinventario.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity()
@Table(name = "customers")
@Data()
public class Customer {

    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Integer id;

    private String name;

    private String id_document;

    private String email;

    private String phone;

    private String address;

    private Date date_birth;

    private Double purchases;

    private Date last_purchase;

    private Date create_at;

    private Date update_at;

    public Customer(String name, String id_document, String email, String phone, String address, Date date_birth, Double purchases, Date last_purchase, Date create_at, Date update_at) {
        this.name = name;
        this.id_document = id_document;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.date_birth = date_birth;
        this.purchases = purchases;
        this.last_purchase = last_purchase;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public Customer() {
    }
}
