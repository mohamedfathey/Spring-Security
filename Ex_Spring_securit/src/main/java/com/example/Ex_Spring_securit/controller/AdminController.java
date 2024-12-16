package com.example.Ex_Spring_securit.controller;

import com.example.Ex_Spring_securit.entity.Admin;
import com.example.Ex_Spring_securit.entity.StandardUser;
import com.example.Ex_Spring_securit.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService ;

    @GetMapping("/all")
    public List<Admin> getAllAdmin(){
        return  adminService.getAllAdmin() ;
    }


    @PostMapping("/insert")
    public ResponseEntity addNewAdmin(@RequestBody Admin admin){
        return  ResponseEntity.ok(adminService.addNewAdmin(admin));
    }
}
