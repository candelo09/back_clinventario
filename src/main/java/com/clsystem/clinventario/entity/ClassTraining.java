package com.clsystem.clinventario.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "classes_training")
@Data
public class ClassTraining {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;

    private Integer max_capacity;

    private Date date_class;

    private Date hour_class;

    private String description;

    private Integer id_user;

    private String type_class;

}
