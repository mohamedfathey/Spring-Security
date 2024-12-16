package com.example.Ex_Spring_securit.service;

import com.example.Ex_Spring_securit.entity.Role;
import com.example.Ex_Spring_securit.entity.SpecialUser;
import com.example.Ex_Spring_securit.repo.SpecialUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialUserService {

    @Autowired
    private SpecialUserRepo specialUserRepo ;

    public List<SpecialUser> getAllSpecialUser(){
        return specialUserRepo.findAll() ;
    }

    public SpecialUser addNewSpecialUser ( SpecialUser specialUser){
        return  specialUserRepo.save(specialUser) ;
    }

}
