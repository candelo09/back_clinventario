package com.clsystem.clinventario.controller;

import com.clsystem.clinventario.entity.Membership;
import com.clsystem.clinventario.services.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "back/memberships")
public class MembershipController {

    @Autowired
    private MembershipService membershipsService;

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<?> getAllMemberships() {
        try {
            return new ResponseEntity<>(membershipsService.findAllMemberships(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<?> saveMembership(@RequestBody Membership membership) {
        try {

            membershipsService.addMembership(membership);

            return new ResponseEntity<>("", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<?> deleteMembership(@PathVariable Long id) {

        try {
            //membership.setId(id);
            membershipsService.removeByIdMembership(id);
            return new ResponseEntity<>("", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit/{id}")
    public @ResponseBody ResponseEntity<?> editUser(@PathVariable Integer id, @RequestBody Membership membership){
        try {
            membership.setId(id);
            membershipsService.updateMembership(membership);
            return new ResponseEntity<>("", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
