package com.youngzy.refactoring.edition1.ch11.tp10;

abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
