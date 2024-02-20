package com.example.product_manager.repository.impl;

import com.example.product_manager.connection.DBConnect;
import com.example.product_manager.dto.ProductDto;
import com.example.product_manager.model.Category;
import com.example.product_manager.repository.ICategoryRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        Connection connection = DBConnect.getConnection();
        try {
            String SELECT_CATEGORY = " select c.id, c.c_name from category c ";
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String cName = resultSet.getString("c_name");
                Category category = new Category(id, cName);
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
}
