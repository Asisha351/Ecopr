package com.example.ecopr.model;

import jakarta.persistence.*;

@Entity
@Table(name = "relations")
public class Relations {

    @Id
    @Column(name = "relation_id")
    private Integer relationId;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Categories category;
    
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;

    @ManyToOne
    @JoinColumn(name = "cloth_id", nullable = false)
    private Cloth cloth;

    public Relations() {}

    public Relations(Integer relationId, Products product, Categories category, Cloth cloth) {
        this.relationId = relationId;
        this.product = product;
        this.category = category;
        this.cloth = cloth;
    }

    // Getters and setters
    public Integer getRelationId() {
        return relationId;
    }

    public void setRelation_id(Integer relation_id) {
        this.relationId = relation_id;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public Cloth getCloth() {
        return cloth;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }

    @Override
    public String toString() {
        return "Relations{ relation_id=" + relationId + ", product=" + product + ", category=" + category + ", cloth=" + cloth + " }";
    }
}
