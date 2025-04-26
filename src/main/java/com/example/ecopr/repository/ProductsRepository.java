package com.example.ecopr.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecopr.model.Products;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products,Integer>{
    Optional<Products> findByProductName(String productName);
}
