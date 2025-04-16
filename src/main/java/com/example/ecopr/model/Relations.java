package com.example.ecopr.model;

import jakarta.persistence.*;

@Entity
@Table(name = "relations")
public class Relations {

    @Id
    @Column(name = "product_id")
    private Long product_id;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "product_id")
    private Products product;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category;

    @ManyToOne
    @JoinColumn(name = "cloth_id")
    private Cloth cloth;

    public Relations() {}

    public Relations(Products product, Categories category, Cloth cloth) {
        this.product = product;
        this.product_id = product.getProduct_id();
        this.category = category;
        this.cloth = cloth;
    }

    // Getters and setters
    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
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
        return "Relations{ product_id=" + product_id + ", product=" + product + ", category=" + category + ", cloth=" + cloth + " }";
    }
}
