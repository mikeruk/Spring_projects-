package com.example.pathfinder_fromscratch.domain.entities;

import com.example.pathfinder_fromscratch.domain.enums.LevelEnum;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2)
    private String username;

//    o Accepts values, which should be at least 2 characters

    @Column(nullable = false)
    @Size(min = 2)
    private String password;
//    o Accepts values, which should be at least 2 characters

    @Column(unique = true)
    private String email;
//    o Accepts values, which contain the '@' symbol


    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
//· role - Accepts Role Entity values
//    o Each registered user should have a "User" role

    @Column()
    @Enumerated(EnumType.STRING)
    private LevelEnum level;
//· level - Accepts a level of the user (BEGINNER, INTERMEDIATE, ADVANCED)

    @Column(nullable = false)
    private String fullName;

    @Column(name = "age")
    private int age;


//    public User() {
//    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
