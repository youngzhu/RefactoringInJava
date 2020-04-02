package com.youngzy.refactoring.edition1.ch01.v05;

public class RegularPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    public double getCharge(int daysRented) {
        double ret = 0;

        ret += 2;
        if (daysRented > 2) {
            ret += (daysRented - 2) * 1.5;
        }

        return ret;
    }
}
