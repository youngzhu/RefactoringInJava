package com.youngzy.refactoring.edition2.ch06.tp03.v00;

public class Foo {
    public double price(int quantity, double itemPrice) {
        // price = base price - quantity discount + shipping
        return quantity * itemPrice -
                Math.max(0, quantity - 500) * itemPrice * 0.05 +
                Math.min(100, quantity * itemPrice * 0.1);
    }
}
