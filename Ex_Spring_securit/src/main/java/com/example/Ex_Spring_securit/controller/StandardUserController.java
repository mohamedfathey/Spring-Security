package com.example.Ex_Spring_securit.controller;

import com.example.Ex_Spring_securit.entity.SpecialUser;
import com.example.Ex_Spring_securit.entity.StandardUser;
import com.example.Ex_Spring_securit.service.StandardUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/STU")
public class StandardUserController {

    @Autowired
    private StandardUserService standardUserService ;
    @GetMapping("/all")
    public List<StandardUser> getAllStandardUser(){
        return  standardUserService.getAllStandardUser() ;
    }


    @PostMapping("/insert")
    public ResponseEntity addNewStandardUser(@RequestBody StandardUser standardUser){
        return  ResponseEntity.ok(standardUserService.addNewStandardUser(standardUser));
    }
}
