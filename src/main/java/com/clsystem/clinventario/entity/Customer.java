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
    @Column(columnDefinition = "serial")
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
}
