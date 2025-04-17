package com.example.ecopr.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer category_id; // Changed to Integer
    
    @Column(name = "category", nullable = false)
    private String category;

    private Set<Relations> relations = new HashSet<>();

    public Categories() {
        // Default constructor
    }

    public Categories(String category) {
        this.category = category;
    }

    // Getters and setters
    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Relations> getRelations() {
        return relations;
    }

    public void setRelations(Set<Relations> relations) {
        this.relations = relations;
    }

    @Override
    public String toString() {
        return "Categories{ category_id=" + category_id + ", category=" + category + " }";
    }
}

