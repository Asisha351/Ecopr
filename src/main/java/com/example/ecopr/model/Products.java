package com.example.ecopr.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "cost", nullable = false)
    private BigDecimal cost;

    @Column(name = "product_url", nullable = false)
    private String productURL;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Relations> relations = new HashSet<>();

    public Products() {
        // Default constructor
    }

    public Products(String productName, BigDecimal cost, String productURL) {
        this.productName = productName;
        this.cost = cost;
        this.productURL = productURL;
    }

    // Getters and setters for attributes
    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getProductURL() {
        return productURL;
    }

    public void setProductURL(String productURL) {
        this.productURL = productURL;
    }

    public Set<Relations> getRelations() {
        return relations;
    }

    public void setRelations(Set<Relations> relations) {
        this.relations = relations;
    }

    @Override
    public String toString() {
        return "Products{ product_id=" + product_id + ", productName=" + productName + ", cost=" + cost + ", productURL=" + productURL + " }";
    }
}
