package com.db.school.demo.order;

import java.sql.Date;

public class Order {
    private int id;
    private java.sql.Date order_date;
    private java.sql.Date shipped_date;
    private String stat;
    private String comments;
    private int customer_id;

    public Order() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrder_date(java.sql.Date order_date) {
        this.order_date = order_date;
    }

    public void setShipped_date(java.sql.Date shipped_date) {
        this.shipped_date = shipped_date;
    }

    public void setStatus(String status) {
        this.stat = status;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getId() {
        return id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public Date getShipped_date() {
        return shipped_date;
    }

    public String getStat() {
        return stat;
    }

    public String getComments() {
        return comments;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public Order(int id, Date order_date, Date shipped_date, String stat, String comments, int customer_id) {
        this.id = id;
        this.order_date = order_date;
        this.shipped_date = shipped_date;
        this.stat = stat;
        this.comments = comments;
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_date=" + order_date +
                ", shipped_date=" + shipped_date +
                ", status='" + stat + '\'' +
                ", comments='" + comments + '\'' +
                ", customer_id=" + customer_id +
                '}';
    }
}
