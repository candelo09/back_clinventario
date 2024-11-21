package com.clsystem.clinventario.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity()
@Table(name = "payments")
@Data
public class Payment {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    private Date paid_date;

    private Double amount;

    private String payment_method;

    private Integer payment_state;

    private Long id_membership;

    private Integer id_customer;

    private Date membership_start_date;

    private Date membership_end_date;
}
