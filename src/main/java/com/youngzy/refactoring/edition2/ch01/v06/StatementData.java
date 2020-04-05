package com.youngzy.refactoring.edition2.ch01.v06;

public class StatementData {

    private String customer;
    private Performance[] performances;

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setPerformances(Performance[] performances) {
        this.performances = performances;
    }

    public Performance[] getPerformances() {
        return performances;
    }
}
