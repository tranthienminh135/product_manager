package com.example.product_manager.repository.impl;

import com.example.product_manager.connection.DBConnect;
import com.example.product_manager.dto.ProductDto;
import com.example.product_manager.model.Product;
import com.example.product_manager.repository.IProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> productDtos = new ArrayList<>();
        Connection connection = DBConnect.getConnection();
        try {
            String SELECT_PRODUCT = " select p.id, p.p_name, p.p_price, c.c_name from product p join product_management.category c on c.id = p.category_id ";
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String pName = resultSet.getString("p_name");
                double price = resultSet.getDouble("p_price");
                String cName = resultSet.getString("c_name");
                ProductDto productDto = new ProductDto(id, pName, price, cName);
                productDtos.add(productDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productDtos;
    }

    @Override
    public void delete(int id) {
        Connection connection = DBConnect.getConnection();
        try {
            String DELETE_PRODUCT = " DELETE FROM product WHERE (id = ?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createProduct(Product product) {
        Connection connection = DBConnect.getConnection();
        try {
            String CREATE_PRODUCT = " INSERT INTO product (p_name, p_price, category_id) VALUES (?, ?, ?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2, product.getProductPrice());
            preparedStatement.setInt(3, product.getCategoryId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        Connection connection = DBConnect.getConnection();
        try {
            String FIND_PRODUCT_BY_ID = " select p.id ,p.p_name ,p.p_price, p.category_id from product p where p.id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String pName = resultSet.getString("p_name");
                double price = resultSet.getDouble("p_price");
                int cId = resultSet.getInt("category_id");
                product = new Product(productId, pName, price, cId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public void edit(Product product) {
        Connection connection = DBConnect.getConnection();
        try {
            String CREATE_PRODUCT = " UPDATE product SET p_name = ?, p_price = ?, category_id = ? WHERE (id = ?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2, product.getProductPrice());
            preparedStatement.setInt(3, product.getCategoryId());
            preparedStatement.setInt(4, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
