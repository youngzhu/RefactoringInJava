package com.youngzy.refactoring.edition1.ch08.tp16.v01;

public class Manager extends EmployeeType {
    @Override
    int getTypeCode() {
        return Employee.MANAGER;
    }
}
