package com.example.ecopr.service;

import com.example.ecopr.model.Products;
import com.example.ecopr.model.Relations;
import com.example.ecopr.repository.RelationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private RelationsRepository relationsRepository;

    @Override
    public List<Products> getProductsByCategory(Long categoryId) {
        List<Relations> relations = relationsRepository.findByCategoryId(categoryId);

        return relations.stream()
                .map(Relations::getProduct)
                .distinct()
                .collect(Collectors.toList());
    }
}
