package com.example.Ex_Spring_securit.controller;

import com.example.Ex_Spring_securit.entity.Role;
import com.example.Ex_Spring_securit.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    private RoleService roleService ;

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('admin')")
    public List<Role> getAllRole(){
        return  roleService.getAllRole() ;
    }


    @PostMapping("/insert")
    public ResponseEntity addNewRole(@RequestBody Role role){
        return  ResponseEntity.ok(roleService.addNewRole(role));
    }

}
