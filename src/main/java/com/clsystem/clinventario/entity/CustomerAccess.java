package com.clsystem.clinventario.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity()
@Data()
public class CustomerAccess {

    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    private String id_document;

    private String name;

    private Date paid_date;

    private BigDecimal amount;

    private String payment_method;

    private Integer payment_state;

    private Integer id_membership;

    private Integer id_customer;

    private Date membership_start_date;

    private Date membership_end_date;

    private String type_membership;

    private BigDecimal weight;

    private BigDecimal body_fat;

    private BigDecimal musculature;

    private BigDecimal stature;

}
