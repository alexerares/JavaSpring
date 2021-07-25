package com.db.school.demo.order;

import com.db.school.demo.customer.Customer;

public interface OrderServiceContract {
    public Order createOrder(Order order);
    public Order getOrder(int id);
    public Order getAllOrder();

    public Boolean insertOrder(Order order);
    public Boolean updateOrder(Order order);

    public Boolean deleteOrder(int id);
}
