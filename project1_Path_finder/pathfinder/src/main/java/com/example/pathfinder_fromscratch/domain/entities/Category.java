package com.example.pathfinder_fromscratch.domain.entities;

import com.example.pathfinder_fromscratch.domain.enums.CategoryEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CategoryEnum name;
//· name - Accepts String values (PEDESTRIAN, BICYCLE, MOTORCYCLE, CAR)

    @Column(columnDefinition = "LONGTEXT", length = 3000)
    private String description;
//· description - Accepts very long String values

    public Category() {
    }

    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
