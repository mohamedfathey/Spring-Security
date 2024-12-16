package com.example.Ex_Spring_securit.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "StandardUser")
public class StandardUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String userName;

    private String email;

    private String password;

    @ManyToOne
    @JoinColumn
    private Role roleC ;

    public StandardUser() {
    }

    public StandardUser(Long id, String userName, String email, String password, Role role) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.roleC = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        return roleC;
    }

    public void setRole(Role role) {
        this.roleC = role;
    }
}
