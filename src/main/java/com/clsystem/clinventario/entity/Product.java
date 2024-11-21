package com.clsystem.clinventario.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity()
@Table(name = "products")
@Data
public class Product {

    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;

    private Integer id_category;

    private Integer code_prod;

    private String description;

    private String laboratory;

    private Date expire_date;

    private String image;

    private Integer stock;

    private BigDecimal purchase_price;

    private BigDecimal sales_price;

    private  Integer invoices;

    private Date create_at;


}
