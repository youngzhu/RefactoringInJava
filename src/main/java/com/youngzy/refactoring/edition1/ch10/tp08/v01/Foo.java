package com.youngzy.refactoring.edition1.ch10.tp08.v01;

public class Foo {
    int quantity;
    double itemPrice;

    public Foo(int quantity, double itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double getPrice() {
        return discountedPrice();
    }

    private double getBasePrice() {
        return quantity * itemPrice;
    }

    private int getDiscountLevel() {
        int discountLevel;
        if (quantity > 100) discountLevel = 2;
        else discountLevel = 1;
        return discountLevel;
    }

    private double discountedPrice() {
        if (getDiscountLevel() == 2) return getBasePrice() * 0.1;
        else return getBasePrice() * 0.05;
    }
}
