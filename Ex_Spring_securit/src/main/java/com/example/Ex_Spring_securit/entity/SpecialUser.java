package com.example.Ex_Spring_securit.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SpecialUser")
public class SpecialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String fullName ;

    private String email ;
    private String password ;

    @ManyToOne
    @JoinColumn
    private Role roleB;

    public SpecialUser() {
    }

    public SpecialUser(Long id, String fullName, String email, String password, Role role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.roleB = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return roleB;
    }

    public void setRole(Role role) {
        this.roleB = role;
    }
}
