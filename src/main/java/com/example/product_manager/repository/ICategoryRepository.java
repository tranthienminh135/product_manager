package com.example.product_manager.repository;

import com.example.product_manager.model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();
}
