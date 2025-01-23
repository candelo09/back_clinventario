package com.clsystem.clinventario.controller;

import com.clsystem.clinventario.entity.User;
import com.clsystem.clinventario.repository.IStorageRepository;
import com.clsystem.clinventario.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "users")
public class UserController {
    @Value("${PATH_FILE_IMAGES}")
    String path_file;

    @Autowired
    private UserService userService;

    @Autowired
    private IStorageRepository storageRepository;

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

            return new ResponseEntity<>("", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<?> deleteUser(@PathVariable Integer id) {

        try {
            userService.removeUser(id);
            return new ResponseEntity<>("", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit/{id}")
    public @ResponseBody ResponseEntity<?> editUser(@PathVariable Integer id, @RequestBody User user){
        try {
            user.setId(id);
            userService.updateUser(user);
            return new ResponseEntity<>("", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<File> upload(@RequestParam("file") MultipartFile file) throws IOException {

        String originalFilename = file.getOriginalFilename();
        String url = storageRepository.store(file.getInputStream(), file.getSize(), file.getContentType(), originalFilename);

        System.out.println(path_file+originalFilename);
        File archivo = new File(path_file+originalFilename);
        archivo.createNewFile();
        FileOutputStream fos = new FileOutputStream(archivo);
        fos.write(file.getBytes());
        fos.close();

        Map<String, Object> data = new HashMap<>();
        data.put("url", url);
        return ResponseEntity.ok(archivo);
    }
}
