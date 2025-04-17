package com.example.ecopr.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecopr.model.Categories;
import java.util.Optional;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
    Optional<Categories> findByCategory(String category);
}
