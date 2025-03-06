package com.clsystem.clinventario.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity()
@Table(name = "physical_progress")
@Data
public class PhysicalProgress {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne
    private User id_user;

    private Double weight;

    private Double body_fat;

    private Double musculature;

    @JoinColumn(name = "id_customer", referencedColumnName = "id")
    @ManyToOne
    private Customer id_customer;

    private Double stature;

    private  Double calf_circumference;

    private Double average_arm_muscle_circumference;

    private Double belt_circumference;

    private Double hip_circumference;

    private Double thigh_circumference;

    private Double relaxed_arm_circumference;

    private Double circumference_contracted_arm;

}
