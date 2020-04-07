package com.youngzy.refactoring.edition2.ch10.tp05.v01;

public class Site {
    private Customer customer;

    public Customer getCustomer() {
        if (null == customer) {
            return new UnknownCustomer();
        }
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
