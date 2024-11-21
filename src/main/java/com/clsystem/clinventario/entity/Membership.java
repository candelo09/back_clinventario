package com.clsystem.clinventario.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "memberships")
@Data
public class Membership {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;

    private String type_membership;

    private Double price;

    private Integer state;

    private Integer code_plan;
}
