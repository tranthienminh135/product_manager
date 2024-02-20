package com.example.product_manager.repository;

import com.example.product_manager.dto.ProductDto;
import com.example.product_manager.model.Product;

import java.util.List;

public interface IProductRepository {
    List<ProductDto> findAll();

    void delete(int id);

    void createProduct(Product product);

    Product findById(int id);

    void edit(Product product);
}
