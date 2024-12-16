package com.example.Ex_Spring_securit.service;

import com.example.Ex_Spring_securit.entity.Role;
import com.example.Ex_Spring_securit.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepo repo ;

    public List<Role>getAllRole(){
        return repo.findAll() ;
    }

    public Role addNewRole ( Role role){
        return  repo.save(role) ;
    }


}
