package com.clsystem.clinventario.controller;


import com.clsystem.clinventario.entity.PhysicalProgress;
import com.clsystem.clinventario.services.PhysicalProgressService;
import com.clsystem.clinventario.services.PhysicalProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "back/phyisical/progress")
public class PhysicalProgressController {

    @Autowired
    private PhysicalProgressService physicalProgressService;

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<?> getAllCategories() {
        try {
            return new ResponseEntity<>(physicalProgressService.findAllPhysicalProgress(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<?> savePhysicalProgress(@RequestBody PhysicalProgress physicalProgress) {
        try {

            physicalProgressService.addPhysicalProgress(physicalProgress);



            return new ResponseEntity<>("",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<?> deletePhysicalProgress(@PathVariable Integer id) {

        try {

            physicalProgressService.removePhysicalProgress(id);
            return new ResponseEntity<>("", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit/{id}")
    public @ResponseBody ResponseEntity<?> editUser(@PathVariable Integer id, @RequestBody PhysicalProgress physicalProgress){
        try {
            physicalProgress.setId(id);
            physicalProgressService.updatePhysicalProgress(physicalProgress);
            return new ResponseEntity<>("", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

//    @GetMapping("/findBy/document")
//    public @ResponseBody ResponseEntity<?> findByDocument(@RequestParam String document) {
//
//        try {
//
//        }catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//
//    }
}
