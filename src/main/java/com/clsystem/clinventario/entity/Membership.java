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
//    @Column(columnDefinition = "serial")
    private Integer id;

    private String type_membership;

    private Double price;

    private Integer state;

    private Integer code_plan;

    public Membership(String type_membership, Double price, Integer state, Integer code_plan) {
        this.type_membership = type_membership;
        this.price = price;
        this.state = state;
        this.code_plan = code_plan;
    }
}
