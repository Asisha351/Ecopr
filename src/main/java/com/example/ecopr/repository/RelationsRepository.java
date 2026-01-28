package com.example.ecopr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecopr.model.Relations;
import java.util.List;

public interface RelationsRepository extends JpaRepository<Relations, Long> {
    List<Relations> findByCategory_CategoryId(Long categoryId);
}
