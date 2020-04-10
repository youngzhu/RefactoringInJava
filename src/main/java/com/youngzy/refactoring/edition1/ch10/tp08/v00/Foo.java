package com.youngzy.refactoring.edition1.ch10.tp08.v00;

public class Foo {
    public double getPrice(int _quantity, double _itemPrice) {
        double basePrice = _quantity * _itemPrice;
        int discountLevel;
        if (_quantity > 100) discountLevel = 2;
        else discountLevel = 1;
        double finalPrice = discountedPrice(basePrice, discountLevel);
        return finalPrice;
    }

    private double discountedPrice(double basePrice, int discountLevel) {
        if (discountLevel == 2) return basePrice * 0.1;
        else return basePrice * 0.05;
    }
}
