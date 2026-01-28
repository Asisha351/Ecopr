package com.example.ecopr.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Categories {

    @Column(name = "category", nullable = false)
    private String category;

    @Id
    @Column(name = "category_id")
    private Long categoryId;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Set<Relations> relations = new HashSet<>();

    public Categories() {
        // Default constructor
    }

    public Categories(String category) {
        this.category = category;
    }

    // Getters and setters
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
        return "Categories{ categoryId=" + categoryId + ", category=" + category + " }";
    }
}

