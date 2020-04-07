package com.youngzy.refactoring.edition2.ch10.tp05.v00;

public class Customer {
    private String name;
    private String billingPlan;
    private int paymentHistory;

    public Customer(String name, String billingPlan, int paymentHistory) {
        this.name = name;
        this.billingPlan = billingPlan;
        this.paymentHistory = paymentHistory;
    }

    public int getPaymentHistory() {
        return paymentHistory;
    }

    public String getName() {
        return name;
    }

    public String getBillingPlan() {
        return billingPlan;
    }

    public void setBillingPlan(String billingPlan) {
        this.billingPlan = billingPlan;
    }
}
