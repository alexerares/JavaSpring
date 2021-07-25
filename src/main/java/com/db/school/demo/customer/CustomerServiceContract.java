package com.db.school.demo.customer;

import java.util.List;

public interface CustomerServiceContract {
    public Customer createCustomer(Customer customer);
    public Customer getCustomer(int id);
    public Customer getAllCustomer();

   public Boolean insertCustomer(Customer customer);
   public Boolean updateCustomer(Customer customer);

   public Boolean deleteCustomer(int id);
}
