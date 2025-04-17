package com.example.ecopr.controller;

import com.example.ecopr.model.Products;
import com.example.ecopr.service.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search")
    public List<Products> searchProductsByCategory(@RequestParam int categoryId) { // Changed to int
        return productService.getProductsByCategory(categoryId);
    }
}
