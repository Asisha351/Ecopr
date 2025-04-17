package com.example.ecopr.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Integer product_id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "cost", nullable = false)
    private Integer cost;

    @Column(name = "product_url", nullable = false)
    private String productURL;

    public Products() {}

    public Products(String productName, Integer cost, String productURL) {
        this.productName = productName;
        this.cost = cost;
        this.productURL = productURL;
    }

    // Getters and setters
    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
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
        return "Products{ product_id=" + product_id + ", productName=" + productName + ", cost=" + cost + ", productURL=" + productURL + " }";
    }
}
