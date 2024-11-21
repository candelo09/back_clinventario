package com.clsystem.clinventario.controller;

import com.clsystem.clinventario.entity.ClassTraining;
import com.clsystem.clinventario.services.ClassTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "class_trainings")
public class ClassTrainingController {

    @Autowired
    private ClassTrainingService classTrainingService;

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<?> getAllClassTraining() {
        try {
            return new ResponseEntity<>(classTrainingService.findAllClassesTraining(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<?> saveClassTraining(@RequestBody ClassTraining class_training) {
        try {

            classTrainingService.addClassTraining(class_training);

            return new ResponseEntity<>("ClassTraining successfully add", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<?> deleteClassTraining(@PathVariable Integer id, @RequestBody ClassTraining class_training) {

        try {
            class_training.setId(id);
            classTrainingService.removeClassTraining(class_training);
            return new ResponseEntity<>("ClassTraining successfully delete", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit/{id}")
    public @ResponseBody ResponseEntity<?> editUser(@PathVariable Integer id, @RequestBody ClassTraining class_training){
        try {
            class_training.setId(id);
            classTrainingService.updateClassTraining(class_training);
            return new ResponseEntity<>("ClassTraining successfully edited", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
