package com.clsystem.clinventario.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity()
@Table(name = "categories")
@Data()
public class Category {

    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id_category;

    private String category;

    private Date created_at;

    private Date update_at;

}
