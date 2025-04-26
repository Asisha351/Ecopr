package com.example.ecopr.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @Column(name = "product_id")
    private Integer productId; // Manually set ID

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "cost", nullable = false)
    private Integer cost;

    @Column(name = "product_url", nullable = false)
    private String productURL;

    public Products() {}

    public Products(Integer productId, String productName, Integer cost, String productURL) {
        this.productId = productId;
        this.productName = productName;
        this.cost = cost;
        this.productURL = productURL;
    }

    // Getters and setters
public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer product_id) {
        this.productId = product_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getProductURL() {
        return productURL;
    }

    public void setProductURL(String productURL) {
        this.productURL = productURL;
    }

    @Override
    public String toString() {
        return "Products{ productId=" + productId + ", productName=" + productName + ", cost=" + cost + ", productURL=" + productURL + " }";
    }
}
