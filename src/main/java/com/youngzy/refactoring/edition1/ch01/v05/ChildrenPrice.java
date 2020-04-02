package com.youngzy.refactoring.edition1.ch01.v05;

public class ChildrenPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDREN;
    }

    public double getCharge(int daysRented) {
        double ret = 0;

        ret += 1.5;
        if (daysRented > 3) {
            ret += (daysRented - 3) * 1.5;
        }

        return ret;
    }
}
