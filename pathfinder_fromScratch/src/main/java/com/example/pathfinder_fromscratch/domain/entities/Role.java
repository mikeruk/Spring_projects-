package com.example.pathfinder_fromscratch.domain.entities;

import com.example.pathfinder_fromscratch.domain.enums.RoleEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{


    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    public Role() {
    }


    public RoleEnum getRole() {
        return role;
    }

    public Role setRole(RoleEnum role) {
        this.role = role;
        return this;
    }
}
