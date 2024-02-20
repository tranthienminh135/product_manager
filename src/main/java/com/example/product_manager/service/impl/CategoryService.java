package com.example.product_manager.service.impl;

import com.example.product_manager.model.Category;
import com.example.product_manager.repository.ICategoryRepository;
import com.example.product_manager.repository.impl.CategoryRepository;
import com.example.product_manager.service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    private ICategoryRepository categoryRepository = new CategoryRepository();

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }
}
