package com.db.school.demo.products;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product=new Product();
        product.setCod(rs.getString("cod"));
        product.setNume(rs.getString("nume"));
        product.setDescriere(rs.getString("descriere"));
        product.setStock(rs.getInt("stock"));
        product.setPrice(rs.getDouble("price"));
        return product;
    }
}