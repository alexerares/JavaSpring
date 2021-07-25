package com.db.school.demo.order;

import com.db.school.demo.customer.Customer;
import com.db.school.demo.customer.CustomerMapper;
import com.db.school.demo.customer.CustomerServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class OrderService implements OrderServiceContract {

    @Autowired
    private JdbcTemplate template;

    public Order createOrder(Order order){
        System.out.println(order);
        return order;
    }

    public Order getOrder(int id){
        List<Order> customers = template.query("SELECT * FROM `db-school`.orders WHERE id =" + id, new OrderMapper());
        System.out.println(customers);
        return new Order(1, Date.valueOf("2015-06-07"),Date.valueOf("2015-06-07"),"shipped","Saluta",1);
    }

    public Order getAllOrder(){
        List<Order> customers = template.query("SELECT * FROM `db-school`.orders", new OrderMapper());
        System.out.println(customers);
        return new Order(1, Date.valueOf("2015-06-07"),Date.valueOf("2015-06-07"),"shipped","Saluta",1);
    }

    public Boolean insertOrder(Order order){
        System.out.println(order);
        String sqlQuery = "INSERT INTO `db-school`.`orders`\n" +
                "(`order_date`,\n" +
                "`shipped_date`,\n" +
                "`stat`,\n" +
                "`comments`,\n" +
                "`customer_id`)\n" +
                "VALUES\n" +
                "(?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?\n" +
                ");";

        int n =template.update(sqlQuery,order.getOrder_date(),order.getShipped_date(),
                order.getStat(),order.getComments(),order.getCustomer_id());

        if (n >0) {
            return true;
        } else {
            return false;
        }

    }

    public Boolean updateOrder(Order order){
        System.out.println(order);
        String sqlQuery = "Update `db-school`.`orders`\n" +
                "SET`order_date` = ?,\n" +
                "`shipped_date` = ?,\n" +
                "`stat` = ?,\n" +
                "`comments` = ?,\n" +
                "`customer_id` = ?\n" +
                "WHERE `id` = ?;";

        int n =template.update(sqlQuery,order.getOrder_date(),order.getShipped_date(),
                order.getStat(),order.getComments(),order.getCustomer_id(),order.getId());

        if (n >0) {
            return true;
        } else {
            return false;
        }

    }
    public Boolean deleteOrder(int id){
        String sqlQuery = "Delete from `db-school`.`orders` WHERE `id` = ?;";

        int n =template.update(sqlQuery, id);

        if (n >0) {
            return true;
        } else {
            return false;
        }
    }
}
