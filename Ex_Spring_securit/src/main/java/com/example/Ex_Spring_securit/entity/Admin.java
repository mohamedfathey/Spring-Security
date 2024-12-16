package com.example.Ex_Spring_securit.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String email ;
    private String password ;

    @ManyToOne
    @JoinColumn
    private Role roleA ;

    public Admin() {
    }

    public Admin(Long id, String email, String password, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roleA = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return roleA;
    }

    public void setRole(Role role) {
        this.roleA = role;
    }
}
