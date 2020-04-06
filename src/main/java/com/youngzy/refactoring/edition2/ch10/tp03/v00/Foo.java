package com.youngzy.refactoring.edition2.ch10.tp03.v00;

import com.youngzy.refactoring.edition2.ch10.tp03.Employee;

public class Foo {
    public double getPayAmount(Employee employee) {
        double ret = 0;

        if (employee.isDead()) {
            ret = 0;
        } else {
            if (employee.isSeparated()) {
                ret = 888;
            } else {
                if (employee.isRetired()) {
                    ret = 600;
                } else {
                    ret = 750;
                }
            }
        }

        return ret;
    }
}
