package com.example.ecopr.model;

import jakarta.persistence.*;

@Entity
@Table(name = "relations")
public class Relations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relation_id")
    private Integer relation_id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Categories category;

    @ManyToOne
    @JoinColumn(name = "cloth_id", nullable = false)
    private Cloth cloth;

    public Relations() {}

    public Relations(Products product, Categories category, Cloth cloth) {
        this.product = product;
        this.category = category;
        this.cloth = cloth;
    }

    // Getters and setters
    public Integer getRelation_id() {
        return relation_id;
    }

    public void setRelation_id(Integer relation_id) {
        this.relation_id = relation_id;
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
        return "Relations{ relation_id=" + relation_id + ", product=" + product + ", category=" + category + ", cloth=" + cloth + " }";
    }
}
