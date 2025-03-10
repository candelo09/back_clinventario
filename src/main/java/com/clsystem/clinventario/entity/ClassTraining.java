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
//    @Column(columnDefinition = "serial")
    private Integer id;

    private Integer max_capacity;

    private Date date_class;

    private Date hour_class;

    private String description;

    private Integer id_user;

    private String type_class;

    public ClassTraining(Integer id, Integer max_capacity, Date date_class, Date hour_class, String description, Integer id_user, String type_class) {
        this.id = id;
        this.max_capacity = max_capacity;
        this.date_class = date_class;
        this.hour_class = hour_class;
        this.description = description;
        this.id_user = id_user;
        this.type_class = type_class;
    }

    public ClassTraining() {
    }
}
