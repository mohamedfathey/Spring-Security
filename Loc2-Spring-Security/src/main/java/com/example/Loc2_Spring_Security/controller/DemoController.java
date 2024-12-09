package com.example.Loc2_Spring_Security.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class DemoController {

    @GetMapping ("/demo")
    public String demo(){
        var u = SecurityContextHolder.getContext().getAuthentication() ;
        u.getAuthorities().forEach(a-> System.out.println(a));
        return "Demo";
    }
}
