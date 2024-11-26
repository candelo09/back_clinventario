package com.clsystem.clinventario.controller;

import com.clsystem.clinventario.entity.User;
import com.clsystem.clinventario.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("all")
    public @ResponseBody ResponseEntity<?> getAllUsers() {

        try {
            return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<?> saveUser(@RequestBody User user) {

        try {
            userService.addUser(user);

            return new ResponseEntity<>("User successfully add", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<?> deleteUser(@PathVariable Integer id, @RequestBody User user) {

        try {
            user.setId(id);
            userService.removeUser(user);
            return new ResponseEntity<>("User successfully delete", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit/{id}")
    public @ResponseBody ResponseEntity<?> editUser(@PathVariable Integer id, @RequestBody User user){
        try {
            user.setId(id);
            userService.updateUser(user);
            return new ResponseEntity<>("User successfully edited", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
