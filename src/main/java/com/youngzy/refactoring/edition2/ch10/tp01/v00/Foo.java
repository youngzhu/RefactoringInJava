package com.youngzy.refactoring.edition2.ch10.tp01.v00;

import java.util.Date;

public class Foo {
    private int quantity;

    public Foo(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount(Date date) {
        double ret = 0;

        int year = new Date().getYear();
        Date summerStart = new Date(year, 6, 1);
        Date summerEnd = new Date(year, 8, 31);

        if (! date.before(summerStart) && ! date.after(summerEnd)) {
            ret = quantity * 0.7;
        } else {
            ret = quantity * 0.85 + 100;
        }
        return ret;
    }
}
