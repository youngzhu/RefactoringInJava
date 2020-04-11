package com.youngzy.refactoring.edition1.ch11.tp10;

public class NewReleasePrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    public int getFrequentRenterPoints(int daysRented) {
        // add bonus for a two day new release rental
        return  (daysRented > 1) ? 2 : 1;
    }
}
