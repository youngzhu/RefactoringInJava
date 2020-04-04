package com.youngzy.refactoring.edition2.ch01.v02;

public class Invoice {
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Performance[] getPerformances() {
        return performances;
    }

    public void setPerformances(Performance[] performances) {
        this.performances = performances;
    }

    private String customer;
    private Performance[] performances;
}
