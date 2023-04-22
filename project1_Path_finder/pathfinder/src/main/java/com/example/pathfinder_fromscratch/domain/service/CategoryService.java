package com.example.pathfinder_fromscratch.domain.service;


import com.example.pathfinder_fromscratch.domain.entities.Category;
import com.example.pathfinder_fromscratch.domain.enums.CategoryEnum;

public interface CategoryService {


    Category findCategoryByName(CategoryEnum categoryEnum);
}
