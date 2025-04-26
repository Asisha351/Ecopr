package com.example.ecopr.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Categories {

    @Id
    @Column(name = "category_id")
    private Integer categoryId; // Manually set ID

    @Column(name = "category", nullable = false)
    private String category;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Relations> relations = new HashSet<>();

    public Categories() {}

    public Categories(Integer categoryId, String category) {
        this.categoryId = categoryId;
        this.category = category;
    }

    // Getters and setters
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
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

