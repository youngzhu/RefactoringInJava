package com.youngzy.refactoring.edition2.ch10.tp01.v01;

import java.util.Date;

public class Foo {
    private int quantity;

    public Foo(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount(Date date) {
        return isSummer(date) ? summerCharge() : regularCharge();
    }

    private double regularCharge() {
        return quantity * 0.85 + 100;
    }

    private double summerCharge() {
        return quantity * 0.7;
    }

    private boolean isSummer(Date date) {
        int year = new Date().getYear();
        Date summerStart = new Date(year, 6, 1);
        Date summerEnd = new Date(year, 8, 31);

        return ! date.before(summerStart) && ! date.after(summerEnd);
    }
}
