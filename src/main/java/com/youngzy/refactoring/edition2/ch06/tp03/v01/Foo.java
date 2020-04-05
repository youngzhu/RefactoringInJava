package com.youngzy.refactoring.edition2.ch06.tp03.v01;

public class Foo {
    public double price(int quantity, double itemPrice) {
        // price = base price - quantity discount + shipping

        final double basePrice = quantity * itemPrice;
        final double quantityDiscount = Math.max(0, quantity - 500) * itemPrice * 0.05;
        final double shipping = Math.min(100, basePrice * 0.1);
        return basePrice - quantityDiscount + shipping;
    }
}
