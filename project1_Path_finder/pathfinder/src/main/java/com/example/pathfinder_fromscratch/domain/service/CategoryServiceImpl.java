package com.example.pathfinder_fromscratch.domain.service;

import com.example.pathfinder_fromscratch.domain.entities.Category;
import com.example.pathfinder_fromscratch.domain.enums.CategoryEnum;
import com.example.pathfinder_fromscratch.domain.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findCategoryByName(CategoryEnum categoryEnum) {
        return categoryRepository
                .findByName(categoryEnum)
                .orElse(null);
    }
}
