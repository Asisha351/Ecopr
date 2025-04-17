package com.example.ecopr.service;

import com.example.ecopr.model.Products;
import java.util.List;

public interface ProductService {
    List<Products> getProductsByCategory(int categoryId); // Changed to int
}
