package com.clsystem.clinventario.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity()
@Table(name = "users")
@Data()
public class User {

    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;

    private String name;

    private String username;

    private String password;

    private String image;

    private  Integer State;

    private Date last_login;

    private Date create_at;

    private String profile;

    private Integer id_membership;

}
