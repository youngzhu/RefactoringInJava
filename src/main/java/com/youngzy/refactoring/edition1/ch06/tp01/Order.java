package com.youngzy.refactoring.edition1.ch06.tp01;

public class Order {
    public Order(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    private Double amount;
}
