package com.youngzy.refactoring.edition1.ch11.tp10;

import com.youngzy.refactoring.edition1.ch11.tp10.Price;

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
