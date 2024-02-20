package com.example.product_manager.model;

public class Product {
    private Integer id;

    private String productName;

    private Double productPrice;

    private Integer categoryId;

    public Product() {
    }

    public Product(Integer id, String productName, Double productPrice, Integer categoryId) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.categoryId = categoryId;
    }

    public Product(String productName, Double productPrice, Integer categoryId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
