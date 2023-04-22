package com.example.pathfinder_fromscratch.domain.repositories;

import com.example.pathfinder_fromscratch.domain.entities.Category;
import com.example.pathfinder_fromscratch.domain.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(CategoryEnum categoryEnum);


}
