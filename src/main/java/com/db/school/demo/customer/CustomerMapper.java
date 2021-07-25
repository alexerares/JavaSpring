package com.db.school.demo.customer;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer=new Customer();
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));
            customer.setAddress(rs.getString("address"));
            customer.setCity(rs.getString("city"));
            customer.setCountry(rs.getString("country"));
            customer.setPhone(rs.getString("phone"));
            customer.setId(rs.getInt("id"));
            customer.setPostalCode(rs.getString("postalCode"));
            customer.setUsername(rs.getString("username"));
            return customer;
        }
}
