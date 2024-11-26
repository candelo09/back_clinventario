package com.clsystem.clinventario.controller;


import com.clsystem.clinventario.entity.User;
import com.clsystem.clinventario.repository.IAuthRepository;
import com.clsystem.clinventario.services.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(path = "api/auth")
@RequiredArgsConstructor
public class LoginController {


    private final AuthServiceImpl authRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> dto) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(authRepository.login(dto));
        } catch (BadCredentialsException | UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("{\"error\": \"Invalid credentials\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
