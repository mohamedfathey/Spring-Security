package com.example.Ex_Spring_securit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name ;

    @OneToMany(mappedBy = "roleB")
    @JsonIgnore
    private List<SpecialUser>specialUsers ;

    @OneToMany(mappedBy = "roleC")
    @JsonIgnore
    private List<StandardUser>standardUsers ;

    @OneToMany(mappedBy = "roleA")
    @JsonIgnore
    private List<Admin>admins ;

    public Role(Long id, String name, List<SpecialUser> specialUsers, List<StandardUser> standardUsers, List<Admin> admins) {
        this.id = id;
        this.name = name;
        this.specialUsers = specialUsers;
        this.standardUsers = standardUsers;
        this.admins = admins;
    }

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SpecialUser> getSpecialUsers() {
        return specialUsers;
    }

    public void setSpecialUsers(List<SpecialUser> specialUsers) {
        this.specialUsers = specialUsers;
    }

    public List<StandardUser> getStandardUsers() {
        return standardUsers;
    }

    public void setStandardUsers(List<StandardUser> standardUsers) {
        this.standardUsers = standardUsers;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }
}
