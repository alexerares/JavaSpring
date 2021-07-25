package com.db.school.demo.order;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order=new Order();
        order.setId(rs.getInt("id"));
        order.setComments(rs.getString("comments"));
        order.setCustomer_id(rs.getInt("customer_id"));
        order.setOrder_date(rs.getDate("order_date"));
        order.setShipped_date(rs.getDate("shipped_date"));
        order.setStatus(rs.getString("stat"));
        return order;
    }
}