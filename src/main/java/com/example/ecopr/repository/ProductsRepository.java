package com.example.ecopr.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecopr.model.Products;

public interface ProductsRepository extends JpaRepository<Products,Long>{
    
}
