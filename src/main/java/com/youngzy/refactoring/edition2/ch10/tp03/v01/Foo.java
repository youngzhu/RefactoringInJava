package com.youngzy.refactoring.edition2.ch10.tp03.v01;

import com.youngzy.refactoring.edition2.ch10.tp03.Employee;

public class Foo {
    public double getPayAmount(Employee employee) {

        if (employee.isDead()) return 0;
        if (employee.isSeparated()) return 888;
        if (employee.isRetired()) return 600;
        return 750;
    }
}
