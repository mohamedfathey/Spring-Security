package com.example.Ex_Spring_securit.service;

import com.example.Ex_Spring_securit.entity.SpecialUser;
import com.example.Ex_Spring_securit.entity.StandardUser;
import com.example.Ex_Spring_securit.repo.StandardUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardUserService {

    @Autowired
    private StandardUserRepo standardUserRepo ;

    public List<StandardUser> getAllStandardUser(){
        return standardUserRepo.findAll() ;
    }

    public StandardUser addNewStandardUser( StandardUser standardUser){
        return  standardUserRepo.save(standardUser) ;
    }

}
