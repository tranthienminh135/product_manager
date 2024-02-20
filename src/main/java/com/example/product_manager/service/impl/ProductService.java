package com.example.product_manager.service.impl;

import com.example.product_manager.dto.ProductDto;
import com.example.product_manager.model.Product;
import com.example.product_manager.repository.IProductRepository;
import com.example.product_manager.repository.impl.ProductRepository;
import com.example.product_manager.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {

    private IProductRepository productRepository = new ProductRepository();

    @Override
    public List<ProductDto> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public void delete(int id) {
        this.productRepository.delete(id);
    }

    @Override
    public void createProduct(Product product) {
        this.productRepository.createProduct(product);
    }

    @Override
    public Product findById(int id) {
        return this.productRepository.findById(id);
    }

    @Override
    public void edit(Product product) {
        this.productRepository.edit(product);
    }
}
