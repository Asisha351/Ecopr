package com.example.ecopr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecopr.model.Relations;
import java.util.List;

public interface RelationsRepository extends JpaRepository<Relations, Long> {
    List<Relations> findBycategory_categoryId(Integer categoryId);

    boolean existsByProduct_ProductIdAndCategory_CategoryIdAndCloth_ClothId(
            Integer productId, Integer categoryId, Integer clothId);
}
