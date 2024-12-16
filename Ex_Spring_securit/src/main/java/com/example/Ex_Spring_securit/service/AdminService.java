package com.example.Ex_Spring_securit.service;

import com.example.Ex_Spring_securit.entity.Admin;
import com.example.Ex_Spring_securit.entity.StandardUser;
import com.example.Ex_Spring_securit.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo ;

    public List<Admin> getAllAdmin(){
        return adminRepo.findAll() ;
    }

    public Admin addNewAdmin( Admin admin){
        return  adminRepo.save(admin) ;
    }

}
