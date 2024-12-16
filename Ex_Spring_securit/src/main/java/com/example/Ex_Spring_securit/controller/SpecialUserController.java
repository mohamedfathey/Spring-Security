package com.example.Ex_Spring_securit.controller;

import com.example.Ex_Spring_securit.entity.Role;
import com.example.Ex_Spring_securit.entity.SpecialUser;
import com.example.Ex_Spring_securit.service.SpecialUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/SU")
public class SpecialUserController {
    @Autowired
    private SpecialUserService service ;

    @GetMapping("/all")
    public List<SpecialUser> getAllSpecialUser(){
        return  service.getAllSpecialUser() ;
    }


    @PostMapping("/insert")
    public ResponseEntity addNewSpecialUser(@RequestBody SpecialUser specialUser){
        return  ResponseEntity.ok(service.addNewSpecialUser(specialUser));
    }
}
