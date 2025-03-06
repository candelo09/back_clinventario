package com.clsystem.clinventario.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
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

    private String document;

    private String email;

    private String phone;

    private String address;

    private LocalDate date_birth;

    private Double purchases;

    private Date last_purchase;

    private Date create_at;

    private Date update_at;

    private String blood_type;

    private String eps;

    private Integer state;
}
