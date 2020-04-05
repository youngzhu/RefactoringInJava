package com.youngzy.refactoring.edition2.ch06.tp01;

import java.util.Date;

public class Invoice {
    private String customer;
    private Date dueDate;
    private Order[] orders;

    public Invoice(String customer, Order[] orders, Date dueDate) {
        this.customer = customer;
        this.orders = orders;
        this.dueDate = dueDate;
    }

    public Order[] getOrders() {
        return this.orders;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getCustomer() {
        return this.customer;
    }

    public Date getDueDate() {
        return this.dueDate;
    }
}
