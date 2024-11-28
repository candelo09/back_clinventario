package com.clsystem.clinventario.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthDto {

    String username;
    String name;
    String token;
}
