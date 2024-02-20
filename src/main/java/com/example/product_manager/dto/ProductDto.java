package com.example.product_manager.dto;

public class ProductDto {
    private Integer id;

    private String productName;

    private Double productPrice;

    private String categoryName;

    public ProductDto() {
    }

    public ProductDto(Integer id, String productName, Double productPrice, String categoryName) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.categoryName = categoryName;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
