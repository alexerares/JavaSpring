package com.db.school.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CustomerServiceContract {

    @Autowired
    private JdbcTemplate template;

    public Customer createCustomer(Customer customer){
        System.out.println(customer);
        return customer;
    }

    public Customer getCustomer(int id){
        List<Customer> customers = template.query("SELECT * FROM `db-school`.customers WHERE id =" + id, new CustomerMapper());
        System.out.println(customers);
        return new Customer(id, "CatalinStircu", "Alex", "Catalin", "0774544179",
                "Strada Izvor", "Constanta", "900365", "Romania");
    }

    public Customer getAllCustomer(){
        List<Customer> customers = template.query("SELECT * FROM `db-school`.customers", new CustomerMapper());
        System.out.println(customers);
        return new Customer(1, "CatalinStircu", "Alex", "Catalin", "0774544179",
                "Strada Izvor", "Constanta", "900365", "Romania");
    }

    public Boolean insertCustomer(Customer customer){
        System.out.println(customer);
        String sqlQuery = "INSERT INTO `db-school`.`customers`\n" +
                "(`username`,\n" +
                "`last_name`,\n" +
                "`first_name`,\n" +
                "`phone`,\n" +
                "`address`,\n" +
                "`city`,\n" +
                "`postalCode`,\n" +
                "`country`)\n" +
                "VALUES\n" +
                "(?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?\n" +
                ");";

        int n =template.update(sqlQuery,customer.getUsername(),customer.getLastName(),
                customer.getFirstName(),customer.getPhone(),customer.getAddress(),customer.getCity(),
                customer.getPostalCode(),customer.getCountry());

        if (n >0) {
            return true;
        } else {
            return false;
        }

    }

    public Boolean updateCustomer(Customer customer){
        System.out.println(customer);
        String sqlQuery = "Update `db-school`.`customers`\n" +
                "SET`username` = ?,\n" +
                "`last_name` = ?,\n" +
                "`first_name` = ?,\n" +
                "`phone` = ?,\n" +
                "`address` = ?,\n" +
                "`city` = ?,\n" +
                "`postalCode` = ?,\n" +
                "`country` = ?\n" +
                "WHERE `id` = ?;";

        int n =template.update(sqlQuery,customer.getUsername(),customer.getLastName(),
                customer.getFirstName(),customer.getPhone(),customer.getAddress(),customer.getCity(),
                customer.getPostalCode(),customer.getCountry(),customer.getId());

        if (n >0) {
            return true;
        } else {
            return false;
        }

    }
    public Boolean deleteCustomer(int id){
        String sqlQuery = "Delete from `db-school`.`customers` WHERE `id` = ?;";

        int n =template.update(sqlQuery, id);

        if (n >0) {
            return true;
        } else {
            return false;
        }
    }
}
